package enterprises.orbital.evexmlapi;

/**
 * Configuration object passed when creating an instance of EveXmlApi.
 */
public class EveXmlApiConfig {
  private String  responsesDirectory = null;
  private String  serverURI          = "https://api.eveonline.com";
  private boolean logResponses       = false;
  private String  agent              = null;
  private int     connectTimeout     = -1;
  private int     readTimeout        = -1;

  private EveXmlApiConfig() {}

  public static EveXmlApiConfig get() {
    return new EveXmlApiConfig();
  }

  public EveXmlApiConfig saveResponses(String responseDir) {
    this.responsesDirectory = responseDir;
    return this;
  }

  public EveXmlApiConfig noSaveResponses() {
    return saveResponses(null);
  }

  public EveXmlApiConfig serverURI(String server) {
    this.serverURI = server;
    return this;
  }

  public EveXmlApiConfig noServerURI() {
    return serverURI("https://api.eveonline.com");
  }

  public EveXmlApiConfig logResponses() {
    this.logResponses = true;
    return this;
  }

  public EveXmlApiConfig noLogResponses() {
    this.logResponses = false;
    return this;
  }

  public EveXmlApiConfig agent(String agentText) {
    this.agent = agentText;
    return this;
  }

  public EveXmlApiConfig noAgent() {
    return agent(null);
  }

  public EveXmlApiConfig connectTimeout(int tm) {
    this.connectTimeout = tm;
    return this;
  }

  public EveXmlApiConfig noConnectTimeout() {
    return connectTimeout(-1);
  }

  public EveXmlApiConfig readTimeout(int tm) {
    this.readTimeout = tm;
    return this;
  }

  public EveXmlApiConfig noReadTimeout() {
    return readTimeout(-1);
  }

  public boolean isSaveResponses() {
    return responsesDirectory != null;
  }

  public String getResponsesDirectory() {
    return responsesDirectory;
  }

  public String getServerURI() {
    return serverURI;
  }

  public boolean isLogResponses() {
    return logResponses;
  }

  public String getAgent() {
    return agent;
  }

  public int getConnectTimeout() {
    return connectTimeout;
  }

  public int getReadTimeout() {
    return readTimeout;
  }

}
