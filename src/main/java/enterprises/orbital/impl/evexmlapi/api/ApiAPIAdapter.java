package enterprises.orbital.impl.evexmlapi.api;

import java.io.IOException;

import enterprises.orbital.evexmlapi.api.IApiAPI;
import enterprises.orbital.evexmlapi.api.ICallList;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.ApiConnector;

public class ApiAPIAdapter extends AbstractAPIRequestAdapter implements IApiAPI {

  public ApiAPIAdapter(ApiConnector connector) {
    super(connector);
  }

  @Override
  public ICallList requestCallList() throws IOException {
    return new CallListParser(connector).retrieveResponse(this);
  }

}
