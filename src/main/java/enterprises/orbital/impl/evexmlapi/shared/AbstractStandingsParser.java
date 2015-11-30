package enterprises.orbital.impl.evexmlapi.shared;

import java.io.IOException;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.shared.IStandingSet;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public abstract class AbstractStandingsParser extends AbstractApiParser<StandingsResponse, IStandingSet> {
  protected String path;

  protected AbstractStandingsParser(ApiConnector connector, ApiEndpoint endpoint, String path) {
    super(connector, StandingsResponse.class, endpoint);
    this.path = path;
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/" + path + "/rowset", StandingsList.class);
    digester.addSetProperties("eveapi/result/" + path + "/rowset");
    digester.addObjectCreate("eveapi/result/" + path + "/rowset/row", ApiStanding.class);
    digester.addSetProperties("eveapi/result/" + path + "/rowset/row");
    digester.addSetNext("eveapi/result/" + path + "/rowset/row", "add");
    digester.addSetNext("eveapi/result/" + path + "/rowset", "addStandingsList");
    return digester;
  }

  @Override
  public IStandingSet retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    StandingsResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    return response;
  }

}