package enterprises.orbital.impl.evexmlapi;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.digester.Digester;

/**
 * Connector which caches the results of previous requests.
 */
public class CachingConnector extends ApiConnector {
  private final Map<ApiRequest, ApiResponse> cache = new HashMap<ApiRequest, ApiResponse>();
  private final ApiConnector                 baseConnector;

  public CachingConnector() {
    this.baseConnector = null;
  }

  public CachingConnector(ApiConnector baseConnector) {
    this.baseConnector = baseConnector;
  }

  @SuppressWarnings("unchecked")
  @Override
  public <E extends ApiResponse> E execute(ApiRequest request, Digester digester, Class<E> clazz) throws IOException {
    if (!cache.containsKey(request)) cache.put(request, getConnector().execute(request, digester, clazz));
    return (E) cache.get(request);
  }

  @Override
  protected ApiConnector getConnector() {
    if (baseConnector != null) return baseConnector;
    return super.getConnector();
  }
}