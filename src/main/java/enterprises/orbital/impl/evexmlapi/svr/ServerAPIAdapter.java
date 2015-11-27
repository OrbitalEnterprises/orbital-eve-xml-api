package enterprises.orbital.impl.evexmlapi.svr;

import java.io.IOException;

import enterprises.orbital.evexmlapi.svr.IServerAPI;
import enterprises.orbital.evexmlapi.svr.IServerStatus;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;

public class ServerAPIAdapter extends AbstractAPIRequestAdapter implements IServerAPI {

  @Override
  public IServerStatus requestServerStatus() throws IOException {
    return new ServerStatusParser().retrieveResponse(this);
  }

}
