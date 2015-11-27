package enterprises.orbital.impl.evexmlapi.crp;

import java.util.HashSet;
import java.util.Set;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class MemberSecurityLogResponse extends ApiResponse {
  private static final long         serialVersionUID = -1136097184283435811L;
  private final Set<ApiRoleHistory> roleHistories    = new HashSet<ApiRoleHistory>();

  public void addRoleHistory(ApiRoleHistory roleHistory) {
    roleHistories.add(roleHistory);
  }

  public Set<ApiRoleHistory> getRoleHistories() {
    return roleHistories;
  }
}