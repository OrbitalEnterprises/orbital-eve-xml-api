package enterprises.orbital.impl.evexmlapi.crp;

import java.util.HashSet;
import java.util.Set;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class MemberTrackingResponse extends ApiResponse {
  private final Set<ApiMember> members = new HashSet<ApiMember>();

  public void addMember(ApiMember member) {
    members.add(member);
  }

  public Set<ApiMember> getMembers() {
    return members;
  }
}
