package enterprises.orbital.impl.evexmlapi.shared;

import java.util.ArrayList;
import java.util.Collection;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class BlueprintsResponse extends ApiResponse {
  private static final long              serialVersionUID = -7577507472040703764L;

  private final Collection<ApiBlueprint> blueprints       = new ArrayList<ApiBlueprint>();

  public void addBlueprint(ApiBlueprint entry) {
    blueprints.add(entry);
  }

  public Collection<ApiBlueprint> getBlueprints() {
    return blueprints;
  }
}