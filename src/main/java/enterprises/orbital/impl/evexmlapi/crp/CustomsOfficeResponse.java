package enterprises.orbital.impl.evexmlapi.crp;

import java.util.ArrayList;
import java.util.Collection;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class CustomsOfficeResponse extends ApiResponse {
  private final Collection<ApiCustomsOffice> offices = new ArrayList<ApiCustomsOffice>();

  public void addCustomsOffice(ApiCustomsOffice facility) {
    offices.add(facility);
  }

  public Collection<ApiCustomsOffice> getOffices() {
    return offices;
  }
}