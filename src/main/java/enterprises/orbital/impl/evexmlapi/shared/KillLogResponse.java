package enterprises.orbital.impl.evexmlapi.shared;

import java.util.ArrayList;
import java.util.Collection;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class KillLogResponse extends ApiResponse {
  private final Collection<ApiKill> kills = new ArrayList<ApiKill>();

  public void addKill(ApiKill entry) {
    kills.add(entry);
  }

  public Collection<ApiKill> getKills() {
    return kills;
  }
}