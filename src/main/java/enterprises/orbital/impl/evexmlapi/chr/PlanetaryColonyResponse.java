package enterprises.orbital.impl.evexmlapi.chr;

import java.util.ArrayList;
import java.util.List;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class PlanetaryColonyResponse extends ApiResponse {
  private final List<ApiPlanetaryColony> colonies = new ArrayList<ApiPlanetaryColony>();

  public void addPlanetaryColony(ApiPlanetaryColony colony) {
    colonies.add(colony);
  }

  public List<ApiPlanetaryColony> getPlanetaryColonies() {
    return colonies;
  }
}