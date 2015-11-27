package enterprises.orbital.impl.evexmlapi.map;

import java.io.IOException;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.map.IMapJump;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class MapJumpsParser extends AbstractApiParser<MapJumpsResponse, IMapJump> {
  public MapJumpsParser() {
    super(MapJumpsResponse.class, ApiEndpoint.MAP_JUMPS_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addBeanPropertySetter("eveapi/result/dataTime");
    digester.addObjectCreate("eveapi/result/rowset/row", ApiSystemJumps.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addSystemJumps");
    return digester;
  }

  @Override
  public IMapJump retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    MapJumpsResponse response = getResponse();
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    return response;
  }

}
