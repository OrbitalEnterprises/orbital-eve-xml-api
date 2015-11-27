package enterprises.orbital.impl.evexmlapi.chr;

import java.util.ArrayList;
import java.util.List;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class PlanetaryLinkResponse extends ApiResponse {
  private static final long            serialVersionUID = -1849627177829410838L;
  private final List<ApiPlanetaryLink> links            = new ArrayList<ApiPlanetaryLink>();

  public void addPlanetaryLink(ApiPlanetaryLink link) {
    links.add(link);
  }

  public List<ApiPlanetaryLink> getPlanetaryLinks() {
    return links;
  }
}