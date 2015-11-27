package enterprises.orbital.impl.evexmlapi;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;

import enterprises.orbital.base.PersistentProperty;
import enterprises.orbital.base.PersistentPropertyKey;

public class EveApi implements PersistentPropertyKey<String> {
  private static final Logger log              = Logger.getLogger(EveApi.class.getName());
  public static final String  LOG_API_FIELD    = "log_api_requests";
  public static final String  SERVER_URL_FIELD = "api_server_url";
  private static final EveApi namespace        = new EveApi();
  private static ApiConnector connector;

  static {
    // Set up connect and enable request logging if desired.
    String serverURL = PersistentProperty.getPropertyWithFallback(namespace, SERVER_URL_FIELD, null);
    URI uri = null;
    try {
      if (serverURL != null) uri = new URI(serverURL);
    } catch (URISyntaxException e) {
      // Log error and reset to default server URI
      log.log(Level.SEVERE, "Failed to create connector with URI: " + serverURL + " using default", e);
      uri = null;
    }
    connector = new ApiConnector(uri);
    boolean logResponses = PersistentProperty.getBooleanPropertyWithFallback(namespace, LOG_API_FIELD, false);
    if (logResponses) connector = new LoggingConnector(connector);
  }

  private EveApi() {}

  public static ApiConnector getConnector() {
    return connector;
  }

  public static void setConnector(ApiConnector connector) {
    EveApi.connector = connector;
  }

  @Override
  public String getPeristentPropertyKey(String field) {
    return EveApi.class.getCanonicalName() + "." + field;
  }

}