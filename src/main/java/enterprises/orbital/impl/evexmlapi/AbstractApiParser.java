package enterprises.orbital.impl.evexmlapi;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.Date;
import java.util.Map;

import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.converters.ArrayConverter;
import org.apache.commons.beanutils.converters.BigDecimalConverter;
import org.apache.commons.beanutils.converters.LongConverter;
import org.apache.commons.digester.Digester;

import enterprises.orbital.impl.evexmlapi.utils.DateUtils;

public abstract class AbstractApiParser<E extends ApiResponse, F> {
  protected final ApiEndpoint endpoint;
  protected final Class<E>    clazz;

  public AbstractApiParser(Class<E> clazz, ApiEndpoint endpoint) {
    this.clazz = clazz;
    this.endpoint = endpoint;
  }

  /**
   * Public interface to retrieve appropriate response type. API adapters call this method after instantiating the parser. Result is null if an error occurs.
   * Caller can interrogate the API adapter to discover the reason for the error.
   * 
   * @param adapter
   *          the adapter on which error information should be set after the call is made.
   * @return a response type appropriate to this parser (usually a public interface), or null if an error occurred.
   * @throws IOException
   *           if an IO error occurred while attempting to retrieve the response.
   */
  public abstract F retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException;

  protected Digester getDigester() {
    Digester digester = new Digester();
    ConvertUtils.register(DateUtils.getGMTConverter(), Date.class);
    ConvertUtils.register(new BigDecimalConverter(null), BigDecimal.class);
    ConvertUtils.register(new ArrayConverter(long[].class, new LongConverter(), -1), long[].class);
    digester.setValidating(false);
    digester.addObjectCreate("eveapi", clazz);
    digester.addSetProperties("eveapi");
    digester.addObjectCreate("eveapi/error", ApiError.class);
    digester.addSetProperties("eveapi/error");
    digester.addBeanPropertySetter("eveapi/error");
    digester.addSetNext("eveapi/error", "setError");
    digester.addBeanPropertySetter("eveapi/currentTime");
    digester.addBeanPropertySetter("eveapi/cachedUntil");
    return digester;
  }

  protected E getResponse() throws IOException {
    return getResponse(new ApiRequest(endpoint));
  }

  protected E getResponse(ApiAuth auth) throws IOException {
    return getResponse(new ApiRequest(endpoint, auth));
  }

  protected E getResponse(ApiAuth auth, String paramName, String paramValue) throws IOException {
    return getResponse(new ApiRequest(endpoint, auth, Collections.singletonMap(paramName, paramValue)));
  }

  protected E getResponse(ApiAuth auth, Map<String, String> extraParams) throws IOException {
    return getResponse(new ApiRequest(endpoint, auth, extraParams));
  }

  protected E getResponse(String paramName, String paramValue) throws IOException {
    return getResponse(new ApiRequest(endpoint, Collections.singletonMap(paramName, paramValue)));
  }

  private E getResponse(ApiRequest request) throws IOException {
    return EveApi.getConnector().execute(request, getDigester(), clazz);
  }
}