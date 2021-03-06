package enterprises.orbital.impl.evexmlapi.chr;

import java.util.ArrayList;
import java.util.List;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class PlanetaryRouteResponse extends ApiResponse {
  private final List<ApiPlanetaryRoute> routes = new ArrayList<ApiPlanetaryRoute>();

  public void addPlanetaryRoute(ApiPlanetaryRoute route) {
    routes.add(route);
  }

  public List<ApiPlanetaryRoute> getPlanetaryRoutes() {
    return routes;
  }
}