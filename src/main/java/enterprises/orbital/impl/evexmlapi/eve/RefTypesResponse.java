package enterprises.orbital.impl.evexmlapi.eve;

import java.util.ArrayList;
import java.util.Collection;

import enterprises.orbital.evexmlapi.eve.IRefType;
import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class RefTypesResponse extends ApiResponse {
  private final Collection<IRefType> refTypes = new ArrayList<IRefType>();

  public void addRefType(ApiRefType refType) {
    refTypes.add(refType);
  }

  public Collection<IRefType> getRefTypes() {
    return refTypes;
  }
}