package enterprises.orbital.impl.evexmlapi.eve;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.eve.IConquerableStation;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class ConquerableStationListParser extends AbstractApiParser<ConquerableStationListResponse, Collection<IConquerableStation>> {
  public ConquerableStationListParser() {
    super(ConquerableStationListResponse.class, ApiEndpoint.EVE_CONQUERABLE_STATION_LIST_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiStation.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addStation");
    return digester;
  }

  @Override
  public Collection<IConquerableStation> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    ConquerableStationListResponse response = getResponse();
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IConquerableStation> result = new HashSet<IConquerableStation>();
    result.addAll(response.getStations().values());
    return result;
  }

}