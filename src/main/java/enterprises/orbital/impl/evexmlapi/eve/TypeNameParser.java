package enterprises.orbital.impl.evexmlapi.eve;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.eve.ITypeName;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class TypeNameParser extends AbstractApiParser<TypeNameResponse, Collection<ITypeName>> {
  private int[] ids;

  public TypeNameParser(ApiConnector connector, int... ids) {
    super(connector, TypeNameResponse.class, ApiEndpoint.EVE_TYPE_NAME_V2);
    this.ids = ids;
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiTypeName.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addTypeName");
    return digester;
  }

  public TypeNameResponse getResponseWithParams() throws IOException {
    return getResponse("ids", Arrays.toString(ids).replace(" ", "").replace("[", "").replace("]", ""));
  }

  @Override
  public Collection<ITypeName> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    TypeNameResponse response = getResponseWithParams();
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    return response.getTypeNames();
  }
}