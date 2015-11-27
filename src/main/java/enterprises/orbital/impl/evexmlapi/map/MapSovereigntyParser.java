package enterprises.orbital.impl.evexmlapi.map;

import java.io.IOException;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.map.ISovereignty;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class MapSovereigntyParser extends AbstractApiParser<MapSovereigntyResponse, ISovereignty> {
  public MapSovereigntyParser() {
    super(MapSovereigntyResponse.class, ApiEndpoint.MAP_SOVEREIGNTY_V1);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addBeanPropertySetter("eveapi/result/dataTime");
    digester.addObjectCreate("eveapi/result/rowset/row", ApiSystemSovereignty.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addSystemSovereignty");
    return digester;
  }

  @Override
  public ISovereignty retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    MapSovereigntyResponse response = getResponse();
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    return response;
  }

}
