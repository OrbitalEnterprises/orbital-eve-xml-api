package enterprises.orbital.impl.evexmlapi.map;

import java.io.IOException;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.map.IMapKill;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class MapKillsParser extends AbstractApiParser<MapKillsResponse, IMapKill> {
  public MapKillsParser() {
    super(MapKillsResponse.class, ApiEndpoint.MAP_KILLS_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addBeanPropertySetter("eveapi/result/dataTime");
    digester.addObjectCreate("eveapi/result/rowset/row", ApiSystemKills.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addSystemKills");
    return digester;
  }

  @Override
  public IMapKill retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    MapKillsResponse response = getResponse();
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    return response;
  }

}
