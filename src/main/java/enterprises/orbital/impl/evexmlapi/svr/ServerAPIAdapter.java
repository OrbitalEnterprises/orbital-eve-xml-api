package enterprises.orbital.impl.evexmlapi.svr;

import java.io.IOException;

import enterprises.orbital.evexmlapi.svr.IServerAPI;
import enterprises.orbital.evexmlapi.svr.IServerStatus;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.ApiConnector;

public class ServerAPIAdapter extends AbstractAPIRequestAdapter implements IServerAPI {

  public ServerAPIAdapter(ApiConnector connector) {
    super(connector);
  }

  @Override
  public IServerStatus requestServerStatus() throws IOException {
    return new ServerStatusParser(connector).retrieveResponse(this);
  }

}
