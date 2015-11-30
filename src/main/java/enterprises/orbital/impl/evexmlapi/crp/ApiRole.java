package enterprises.orbital.impl.evexmlapi.crp;

import enterprises.orbital.evexmlapi.crp.IRole;

public class ApiRole implements IRole {
  private long   roleID;
  private String roleName;
  private String roleDescription;

  @Override
  public long getRoleID() {
    return roleID;
  }

  public void setRoleID(long roleID) {
    this.roleID = roleID;
  }

  @Override
  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  @Override
  public String getRoleDescription() {
    return roleDescription;
  }

  public void setRoleDescription(String roleDescription) {
    this.roleDescription = roleDescription;
  }
}