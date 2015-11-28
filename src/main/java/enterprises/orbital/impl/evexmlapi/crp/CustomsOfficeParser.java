package enterprises.orbital.impl.evexmlapi.crp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.crp.ICustomsOffice;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class CustomsOfficeParser extends AbstractApiParser<CustomsOfficeResponse, Collection<ICustomsOffice>> {
  public CustomsOfficeParser(ApiConnector connector) {
    super(connector, CustomsOfficeResponse.class, ApiEndpoint.CRP_CUSTOMS_OFFICES_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiCustomsOffice.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addCustomsOffice");
    return digester;
  }

  @Override
  public Collection<ICustomsOffice> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    CustomsOfficeResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<ICustomsOffice> result = new ArrayList<ICustomsOffice>();
    result.addAll(response.getOffices());
    return result;
  }

}