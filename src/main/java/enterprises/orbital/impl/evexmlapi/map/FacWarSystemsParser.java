package enterprises.orbital.impl.evexmlapi.map;

import java.io.IOException;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.map.IFacWarSystem;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class FacWarSystemsParser extends AbstractApiParser<FacWarSystemsResponse, Collection<IFacWarSystem>> {
  public FacWarSystemsParser() {
    super(FacWarSystemsResponse.class, ApiEndpoint.MAP_FAC_WAR_SYSTEMS_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiFacWarSystem.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addSystem");
    return digester;
  }

  @Override
  public Collection<IFacWarSystem> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    FacWarSystemsResponse response = getResponse();
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    return response.getSystems();
  }

}