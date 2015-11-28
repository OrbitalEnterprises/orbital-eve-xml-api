package enterprises.orbital.impl.evexmlapi.shared;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;

import enterprises.orbital.evexmlapi.shared.IKill;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiAuth;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public abstract class AbstractKillMailsParser extends AbstractApiParser<KillLogResponse, Collection<IKill>> {
  protected Long beforeKillID;

  protected AbstractKillMailsParser(ApiConnector connector, ApiEndpoint endpoint, Long beforeKillID) {
    super(connector, KillLogResponse.class, endpoint);
    this.beforeKillID = beforeKillID;
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    AbstractObjectCreationFactory factory = new AbstractObjectCreationFactory() {
      @Override
      public Object createObject(Attributes attributes) throws Exception {
        if (attributes.getValue("characterID") != null) return new ApiKillAttacker();
        if (attributes.getValue("typeID") != null) return new ApiKillItem();
        return null;
      }
    };
    digester.addObjectCreate("eveapi/result/rowset/row", ApiKill.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addObjectCreate("eveapi/result/rowset/row/victim", ApiKillVictim.class);
    digester.addSetProperties("eveapi/result/rowset/row/victim");
    digester.addSetNext("eveapi/result/rowset/row/victim", "setVictim");
    digester.addFactoryCreate("*/rowset/row", factory);
    digester.addSetProperties("*/rowset/row");
    digester.addSetNext("*/rowset/row", "addKillDetail");
    digester.addSetNext("eveapi/result/rowset/row", "addKill");
    return digester;
  }

  public KillLogResponse getResponseWithBeforeKillID(ApiAuth auth) throws IOException {
    if (beforeKillID != null) {
      Map<String, String> extraParams = new HashMap<String, String>();
      extraParams.put("beforeKillID", Long.toString(beforeKillID));
      return getResponse(auth, extraParams);
    } else
      return getResponse(auth);
  }

  @Override
  public Collection<IKill> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    KillLogResponse response = getResponseWithBeforeKillID(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IKill> result = new ArrayList<IKill>();
    result.addAll(response.getKills());
    return result;
  }

}
