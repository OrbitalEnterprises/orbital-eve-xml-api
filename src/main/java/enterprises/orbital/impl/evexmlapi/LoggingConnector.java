package enterprises.orbital.impl.evexmlapi;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.digester.Digester;

import enterprises.orbital.impl.evexmlapi.utils.InputStreamSplitter;

public class LoggingConnector extends ApiConnector {
  private static final Logger logger = Logger.getLogger(LoggingConnector.class.getName());

  private final ApiConnector  baseConnector;

  public LoggingConnector() {
    this.baseConnector = null;
  }

  public LoggingConnector(ApiConnector baseConnector) {
    this.baseConnector = baseConnector;
  }

  @Override
  public <E extends ApiResponse> E execute(ApiRequest request, Digester digester, Class<E> clazz) throws IOException {
    if (logger.isLoggable(Level.INFO)) logger.info("\nRequest:\n" + request.toString());
    ApiConnector connector = getConnector();
    URI url = connector.getURI(request);
    Map<String, String> params = connector.getParams(request);
    InputStream is = connector.getInputStream(url, params);
    return getApiResponse(digester, is, clazz);
  }

  @Override
  @SuppressWarnings("unchecked")
  protected <E> E getApiResponse(Digester digester, InputStream inputStream, Class<E> clazz) throws IOException {
    ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    if (logger.isLoggable(Level.INFO)) {
      inputStream = new InputStreamSplitter(inputStream, outputStream);
    }
    try {
      return (E) digester.parse(inputStream);
    } catch (IOException e) {
      throw e;
    } catch (Exception e) {
      throw new IOException(e);
    } finally {
      logger.info("\nResponse:\n" + outputStream.toString());
    }
  }

  @Override
  protected ApiConnector getConnector() {
    if (baseConnector != null) return baseConnector;
    return super.getConnector();
  }
}