package enterprises.orbital.evexmlapi;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

import enterprises.orbital.evexmlapi.act.IAccountAPI;
import enterprises.orbital.evexmlapi.api.IApiAPI;
import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.eve.IEveAPI;
import enterprises.orbital.evexmlapi.map.IMapAPI;
import enterprises.orbital.evexmlapi.svr.IServerAPI;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.FileCopyConnector;
import enterprises.orbital.impl.evexmlapi.LoggingConnector;
import enterprises.orbital.impl.evexmlapi.act.AccountAPIAdapter;
import enterprises.orbital.impl.evexmlapi.api.ApiAPIAdapter;
import enterprises.orbital.impl.evexmlapi.chr.CharacterAPIAdapter;
import enterprises.orbital.impl.evexmlapi.crp.CorporationAPIAdapter;
import enterprises.orbital.impl.evexmlapi.eve.EveAPIAdapter;
import enterprises.orbital.impl.evexmlapi.map.MapAPIAdapter;
import enterprises.orbital.impl.evexmlapi.svr.ServerAPIAdapter;

public class EveXmlApiAdapter implements IEveXmlApi {
  private ApiConnector connector;

  public EveXmlApiAdapter() throws URISyntaxException {
    this(EveXmlApiConfig.get());
  }

  public EveXmlApiAdapter(EveXmlApiConfig config) throws URISyntaxException {
    // Set the connector for all adapters from this instance
    URI uri = new URI(config.getServerURI());
    connector = new ApiConnector(uri, config.getAgent(), config.getConnectTimeout(), config.getReadTimeout());
    if (config.isLogResponses()) connector = new LoggingConnector(connector);
    if (config.isSaveResponses()) connector = new FileCopyConnector(connector, new File(config.getResponsesDirectory() + File.separator + "eveapiresponses"));
  }

  public EveXmlApiAdapter setConnector(ApiConnector connector) {
    // WARNING: EXPERTS ONLY!
    this.connector = connector;
    return this;
  }

  @Override
  public IServerAPI getServerAPIService() {
    return new ServerAPIAdapter(connector);
  }

  @Override
  public IAccountAPI getAccountAPIService(int userID, String apiKey) {
    return new AccountAPIAdapter(connector, userID, apiKey);
  }

  @Override
  public ICharacterAPI getCharacterAPIService(int userID, String apiKey, long characterID) {
    return new CharacterAPIAdapter(connector, userID, characterID, apiKey);
  }

  @Override
  public ICorporationAPI getCorporationAPIService(int userID, String apiKey, long characterID) {
    return new CorporationAPIAdapter(connector, userID, characterID, apiKey);
  }

  @Override
  public IEveAPI getEveAPIService() {
    return new EveAPIAdapter(connector);
  }

  @Override
  public IMapAPI getMapAPIService() {
    return new MapAPIAdapter(connector);
  }

  @Override
  public IApiAPI getApiAPIService() {
    return new ApiAPIAdapter(connector);
  }

}
