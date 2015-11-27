package enterprises.orbital.impl.evexmlapi.svr;

import enterprises.orbital.evexmlapi.svr.IServerStatus;
import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class ServerStatusResponse extends ApiResponse implements IServerStatus {
  private static final long serialVersionUID = 1L;
  private boolean           serverOpen;
  private int               onlinePlayers;

  @Override
  public boolean isServerOpen() {
    return serverOpen;
  }

  public void setServerOpen(boolean serverOpen) {
    this.serverOpen = serverOpen;
  }

  @Override
  public int getOnlinePlayers() {
    return onlinePlayers;
  }

  public void setOnlinePlayers(int onlinePlayers) {
    this.onlinePlayers = onlinePlayers;
  }
}
