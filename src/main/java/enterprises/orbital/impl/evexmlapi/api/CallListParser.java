package enterprises.orbital.impl.evexmlapi.api;

import java.io.IOException;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.api.ICallList;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class CallListParser extends AbstractApiParser<CallListResponse, ICallList> {
  public CallListParser(ApiConnector connector) {
    super(connector, CallListResponse.class, ApiEndpoint.API_CALL_LIST_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiCallOrGroup.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addCallOrGroup");
    return digester;
  }

  @Override
  public ICallList retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    CallListResponse response = getResponse();
    adapter.setFromLastResponse(response);
    return adapter.isError() ? null : response;
  }
}