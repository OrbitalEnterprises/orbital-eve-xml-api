package enterprises.orbital.impl.evexmlapi.crp;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.crp.IStarbase;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class StarbaseListParser extends AbstractApiParser<StarbaseListResponse, Collection<IStarbase>> {
  public StarbaseListParser(ApiConnector connector) {
    super(connector, StarbaseListResponse.class, ApiEndpoint.CRP_STARBASE_LIST_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiStarbase.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addStarbase");
    return digester;
  }

  @Override
  public Collection<IStarbase> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    StarbaseListResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IStarbase> result = new HashSet<IStarbase>();
    result.addAll(response.getStarbases());
    return result;
  }

}