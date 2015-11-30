package enterprises.orbital.impl.evexmlapi;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Class encapsulating an API request which consists of:
 * <ul>
 * <li>An ApiEndpooint
 * <li>An optional ApiAuth containing credentials
 * <li>An optional Map<String, String> of query parameters
 * </ul>
 */
public class ApiRequest implements Comparable<ApiRequest> {
  private final ApiEndpoint         endpoint;
  private final ApiAuth             auth;
  private final Map<String, String> params;

  public ApiRequest(ApiEndpoint endpoint, ApiAuth auth, Map<String, String> params) {
    this.endpoint = endpoint;
    this.auth = auth;
    this.params = params;
  }

  public ApiRequest(ApiEndpoint endpoint, Map<String, String> params) {
    this(endpoint, null, params);
  }

  public ApiRequest(ApiEndpoint endpoint, ApiAuth auth) {
    this(endpoint, auth, new HashMap<String, String>());
  }

  public ApiRequest(ApiEndpoint endpoint) {
    this(endpoint, null, new HashMap<String, String>());
  }

  public ApiEndpoint getEndpoint() {
    return endpoint;
  }

  public ApiAuth getAuth() {
    return auth;
  }

  public Map<String, String> getParams() {
    return params;
  }

  @Override
  public int hashCode() {
    StringBuilder temp = new StringBuilder(endpoint.getPath());
    temp.append(endpoint.getVersion()).append(auth.getKeyID()).append(auth.getCharacterID()).append(auth.getVCode());
    for (Entry<String, String> entry : params.entrySet()) {
      temp.append(entry.getKey()).append(entry.getValue());
    }
    return temp.toString().hashCode();
  }

  @Override
  public int compareTo(ApiRequest o) {
    return o.hashCode() - hashCode();
  }

  @Override
  public boolean equals(Object obj) {
    if (obj instanceof ApiRequest) return compareTo((ApiRequest) obj) == 0;
    return false;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append("Endpoint: ").append(endpoint).append("\n");
    result.append("Auth: ").append(String.valueOf(auth)).append("\n");
    for (Entry<String, String> entry : params.entrySet()) {
      result.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
    }
    return result.toString();
  }
}