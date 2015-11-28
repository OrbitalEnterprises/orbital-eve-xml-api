package enterprises.orbital.impl.evexmlapi.eve;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.eve.IAlliance;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class AllianceListParser extends AbstractApiParser<AllianceListResponse, Collection<IAlliance>> {
  public AllianceListParser(ApiConnector connector) {
    super(connector, AllianceListResponse.class, ApiEndpoint.EVE_ALLIANCE_LIST_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiAlliance.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addObjectCreate("eveapi/result/rowset/row/rowset/row", ApiMemberCorporation.class);
    digester.addSetProperties("eveapi/result/rowset/row/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row/rowset/row", "addMemberCorporation");
    digester.addSetNext("eveapi/result/rowset/row", "addAlliance");
    return digester;
  }

  @Override
  public Collection<IAlliance> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    AllianceListResponse response = getResponse();
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IAlliance> result = new ArrayList<IAlliance>();
    result.addAll(response.getAlliances());
    return result;
  }

}