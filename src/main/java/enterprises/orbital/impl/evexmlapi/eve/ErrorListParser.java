package enterprises.orbital.impl.evexmlapi.eve;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.eve.IError;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class ErrorListParser extends AbstractApiParser<ErrorListResponse, Collection<IError>> {
  public ErrorListParser(ApiConnector connector) {
    super(connector, ErrorListResponse.class, ApiEndpoint.EVE_ERROR_LIST_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiErrorListItem.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addApiErrorListItem");
    return digester;
  }

  @Override
  public Collection<IError> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    ErrorListResponse response = getResponse();
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IError> result = new ArrayList<IError>();
    result.addAll(response.getApiErrorListItems());
    return result;
  }

}