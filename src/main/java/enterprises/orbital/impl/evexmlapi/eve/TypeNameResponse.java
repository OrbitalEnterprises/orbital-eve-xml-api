package enterprises.orbital.impl.evexmlapi.eve;

import java.util.Collection;
import java.util.HashSet;

import enterprises.orbital.evexmlapi.eve.ITypeName;
import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class TypeNameResponse extends ApiResponse {
  private final Collection<ITypeName> types = new HashSet<ITypeName>();

  public Collection<ITypeName> getTypeNames() {
    return types;
  }

  public void addTypeName(ApiTypeName lookup) {
    types.add(lookup);
  }
}