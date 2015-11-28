package enterprises.orbital.impl.evexmlapi.crp;

import java.util.Collection;
import java.util.HashSet;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class OutpostServiceDetailResponse extends ApiResponse {
  private final Collection<ApiOutpostServiceDetail> outposts = new HashSet<ApiOutpostServiceDetail>();

  public void addOutpost(ApiOutpostServiceDetail outpost) {
    outposts.add(outpost);
  }

  public Collection<ApiOutpostServiceDetail> getOutposts() {
    return outposts;
  }
}
