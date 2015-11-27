package enterprises.orbital.impl.evexmlapi.map;

import java.util.ArrayList;
import java.util.List;

import enterprises.orbital.evexmlapi.map.IFacWarSystem;
import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class FacWarSystemsResponse extends ApiResponse {
  private static final long         serialVersionUID = -6519282956553240503L;
  private final List<IFacWarSystem> systems          = new ArrayList<IFacWarSystem>();

  public void addSystem(ApiFacWarSystem system) {
    systems.add(system);
  }

  public List<IFacWarSystem> getSystems() {
    return systems;
  }
}