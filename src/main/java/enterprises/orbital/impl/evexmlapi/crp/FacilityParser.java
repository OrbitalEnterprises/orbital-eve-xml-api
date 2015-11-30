package enterprises.orbital.impl.evexmlapi.crp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.crp.IFacility;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class FacilityParser extends AbstractApiParser<FacilityResponse, Collection<IFacility>> {
  public FacilityParser(ApiConnector connector) {
    super(connector, FacilityResponse.class, ApiEndpoint.CRP_FACILITIES_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiFacility.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addFacility");
    return digester;
  }

  @Override
  public Collection<IFacility> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    FacilityResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IFacility> result = new ArrayList<IFacility>();
    result.addAll(response.getFacilities());
    return result;
  }

}