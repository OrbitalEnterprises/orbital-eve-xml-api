package enterprises.orbital.impl.evexmlapi.crp;

import java.util.HashSet;
import java.util.Set;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class MemberSecurityResponse extends ApiResponse {
  private final Set<ApiSecurityMember> members = new HashSet<ApiSecurityMember>();

  public void addMember(ApiSecurityMember member) {
    members.add(member);
  }

  public Set<ApiSecurityMember> getMembers() {
    return members;
  }
}