package enterprises.orbital.impl.evexmlapi;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.digester.Digester;
import org.apache.http.client.utils.URIBuilder;
import org.xml.sax.SAXException;

import enterprises.orbital.base.PersistentProperty;
import enterprises.orbital.base.PersistentPropertyKey;

public class ApiConnector implements PersistentPropertyKey<String> {
  public static final String  AGENT_FIELD           = "agent";
  public static final String  CONNECT_TIMEOUT_FIELD = "connectTimeout";
  public static final String  READ_TIMEOUT_FIELD    = "readTimeout";
  private static final String DEFAULT_EVE_API_URI   = "https://api.eveonline.com";
  private final URI           baseURI;

  public ApiConnector() {
    this(null);
  }

  public ApiConnector(URI uri) {
    if (uri == null) {
      try {
        uri = new URI(DEFAULT_EVE_API_URI);
      } catch (URISyntaxException e) {
        // this should never happen
        assert false;
      }
    }
    this.baseURI = uri;
  }

  public <E extends ApiResponse> E execute(ApiRequest request, Digester digester, Class<E> clazz) throws IOException {
    return getApiResponse(digester, getInputStream(getURI(request), getParams(request)), clazz);
  }

  @SuppressWarnings("unchecked")
  protected <E> E getApiResponse(Digester digester, InputStream inputStream, Class<E> clazz) throws IOException {
    try {
      return (E) digester.parse(inputStream);
    } catch (SAXException e) {
      // re-throw as IOException
      throw new IOException(e);
    }
  }

  protected InputStream getInputStream(URI requestUri, Map<String, String> params) throws IOException {
    OutputStreamWriter wr = null;
    try {
      URIBuilder builder = new URIBuilder(requestUri);
      for (Entry<String, String> entry : params.entrySet()) {
        builder.addParameter(entry.getKey(), entry.getValue());
      }
      URL getter = builder.build().toURL();
      URLConnection conn = getter.openConnection();
      String agent = PersistentProperty.getProperty(this, ApiConnector.AGENT_FIELD, null);
      int connectTimeout = PersistentProperty.getIntegerPropertyWithFallback(this, ApiConnector.CONNECT_TIMEOUT_FIELD, -1);
      int readTimeout = PersistentProperty.getIntegerPropertyWithFallback(this, ApiConnector.READ_TIMEOUT_FIELD, -1);
      if (agent != null) conn.setRequestProperty("User-Agent", agent);
      // Timeout settings
      if (connectTimeout > -1) conn.setConnectTimeout(connectTimeout);
      if (readTimeout > -1) conn.setReadTimeout(readTimeout);
      return conn.getInputStream();
    } catch (URISyntaxException e) {
      // re-throw as IOException
      throw new IOException(e);
    } finally {
      if (wr != null) try {
        wr.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }

  }

  protected URI getURI(ApiRequest request) throws IOException {
    URIBuilder builder = new URIBuilder(getBaseURI());
    builder.setPath(builder.getPath() + request.getEndpoint().getPath() + ".xml.aspx");
    try {
      return builder.build();
    } catch (URISyntaxException e) {
      // re-throw as IOException
      throw new IOException(e);
    }
  }

  protected Map<String, String> getParams(ApiRequest request) {
    Map<String, String> result = new HashMap<String, String>();
    result.put("version", Integer.toString(request.getEndpoint().getVersion()));
    ApiAuth auth = request.getAuth();
    if (auth != null) result.putAll(auth.getParams());
    Map<String, String> params = request.getParams();
    if (params != null) {
      result.putAll(params);
    }
    return result;
  }

  protected URI getBaseURI() {
    return baseURI;
  }

  protected ApiConnector getConnector() {
    return this;
  }

  @Override
  public String getPeristentPropertyKey(String field) {
    return ApiConnector.class.getCanonicalName() + "." + field;
  }
}