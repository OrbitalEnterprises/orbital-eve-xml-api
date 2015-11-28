package enterprises.orbital.impl.evexmlapi.eve;

import java.util.ArrayList;
import java.util.Collection;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class AllianceListResponse extends ApiResponse {
  private final Collection<ApiAlliance> alliances = new ArrayList<ApiAlliance>();

  public void addAlliance(ApiAlliance alliance) {
    alliances.add(alliance);
  }

  public Collection<ApiAlliance> getAlliances() {
    return alliances;
  }
}