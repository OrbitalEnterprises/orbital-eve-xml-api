package enterprises.orbital.impl.evexmlapi.shared;

import java.util.ArrayList;
import java.util.Collection;

import enterprises.orbital.evexmlapi.shared.ILocation;
import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class LocationsResponse extends ApiResponse {
  private final Collection<ILocation> locations = new ArrayList<ILocation>();

  public void addLocation(ApiLocation order) {
    locations.add(order);
  }

  public Collection<ILocation> getLocations() {
    return locations;
  }
}
