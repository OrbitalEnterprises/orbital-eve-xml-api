package enterprises.orbital.impl.evexmlapi.eve;

import java.util.ArrayList;
import java.util.Collection;

import enterprises.orbital.evexmlapi.eve.IRefType;
import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class RefTypesResponse extends ApiResponse {
  private static final long          serialVersionUID = 5372629282555417333L;
  private final Collection<IRefType> refTypes         = new ArrayList<IRefType>();

  public void addRefType(ApiRefType refType) {
    refTypes.add(refType);
  }

  public Collection<IRefType> getRefTypes() {
    return refTypes;
  }
}