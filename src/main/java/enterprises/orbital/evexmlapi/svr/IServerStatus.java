package enterprises.orbital.evexmlapi.svr;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IServerStatus.class)
public interface IServerStatus {
  public int getOnlinePlayers();

  public boolean isServerOpen();
}
