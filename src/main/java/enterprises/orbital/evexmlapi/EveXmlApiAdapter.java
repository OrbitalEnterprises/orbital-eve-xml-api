package enterprises.orbital.evexmlapi;

import java.beans.XMLEncoder;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.Serializable;

import enterprises.orbital.evexmlapi.act.IAccountAPI;
import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.eve.IEveAPI;
import enterprises.orbital.evexmlapi.map.IMapAPI;
import enterprises.orbital.evexmlapi.svr.IServerAPI;
import enterprises.orbital.impl.evexmlapi.EveApi;
import enterprises.orbital.impl.evexmlapi.FileCopyConnector;
import enterprises.orbital.impl.evexmlapi.act.AccountAPIAdapter;
import enterprises.orbital.impl.evexmlapi.chr.CharacterAPIAdapter;
import enterprises.orbital.impl.evexmlapi.crp.CorporationAPIAdapter;
import enterprises.orbital.impl.evexmlapi.eve.EveAPIAdapter;
import enterprises.orbital.impl.evexmlapi.map.MapAPIAdapter;
import enterprises.orbital.impl.evexmlapi.svr.ServerAPIAdapter;

public class EveXmlApiAdapter implements IEveXmlApi {

  public void startup() {
    // Change the connector if debugging desired
    boolean saveResponses = Boolean.valueOf(System.getProperty("org.dps.core.impl.server.eveapi.saveresponses", "false"));
    String responseDir = System.getProperty("org.dps.core.impl.server.eveapi.responsedir", System.getProperty("user.home"));
    if (saveResponses) {
      EveApi.setConnector(new FileCopyConnector(new File(responseDir + File.separator + "eveapiresponses")));
    }
  }

  @Override
  public IServerAPI getServerAPIService() {
    return new ServerAPIAdapter();
  }

  @Override
  public IAccountAPI getAccountAPIService(int userID, String apiKey) {
    return new AccountAPIAdapter(userID, apiKey);
  }

  @Override
  public ICharacterAPI getCharacterAPIService(int userID, String apiKey, long characterID) {
    return new CharacterAPIAdapter(userID, characterID, apiKey);
  }

  @Override
  public ICorporationAPI getCorporationAPIService(int userID, String apiKey, long characterID) {
    return new CorporationAPIAdapter(userID, characterID, apiKey);
  }

  @Override
  public IEveAPI getEveAPIService() {
    return new EveAPIAdapter();
  }

  @Override
  public IMapAPI getMapAPIService() {
    return new MapAPIAdapter();
  }

  public static String xmlPrettyPrint(Serializable proxy) {
    ByteArrayOutputStream capture = new ByteArrayOutputStream();
    XMLEncoder e = new XMLEncoder(capture);
    e.writeObject(proxy);
    e.close();
    return capture.toString();
  }

}
