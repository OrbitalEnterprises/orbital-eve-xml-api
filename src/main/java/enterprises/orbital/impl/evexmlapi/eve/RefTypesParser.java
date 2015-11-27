package enterprises.orbital.impl.evexmlapi.eve;

import java.io.IOException;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.eve.IRefType;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class RefTypesParser extends AbstractApiParser<RefTypesResponse, Collection<IRefType>> {
  public RefTypesParser() {
    super(RefTypesResponse.class, ApiEndpoint.EVE_REF_TYPES_V1);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiRefType.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addRefType");
    return digester;
  }

  @Override
  public Collection<IRefType> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    RefTypesResponse response = getResponse();
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    return response.getRefTypes();
  }

}