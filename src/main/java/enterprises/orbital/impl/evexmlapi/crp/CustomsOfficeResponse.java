package enterprises.orbital.impl.evexmlapi.crp;

import java.util.ArrayList;
import java.util.Collection;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class CustomsOfficeResponse extends ApiResponse {
  private static final long                  serialVersionUID = 3486619377030605161L;
  private final Collection<ApiCustomsOffice> offices          = new ArrayList<ApiCustomsOffice>();

  public void addCustomsOffice(ApiCustomsOffice facility) {
    offices.add(facility);
  }

  public Collection<ApiCustomsOffice> getOffices() {
    return offices;
  }
}