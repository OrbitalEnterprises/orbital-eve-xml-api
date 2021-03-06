package enterprises.orbital.impl.evexmlapi.crp;

import java.util.ArrayList;
import java.util.Collection;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class FacilityResponse extends ApiResponse {
  private final Collection<ApiFacility> facilities = new ArrayList<ApiFacility>();

  public void addFacility(ApiFacility facility) {
    facilities.add(facility);
  }

  public Collection<ApiFacility> getFacilities() {
    return facilities;
  }
}