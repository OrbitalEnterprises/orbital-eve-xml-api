package enterprises.orbital.impl.evexmlapi.crp;

import enterprises.orbital.evexmlapi.crp.ISecurityRole;

public class ApiSecurityRole implements ISecurityRole {
  private long   roleID;
  private String roleName;

  public ApiSecurityRole() {
    // default constructor needed for Digester
  }

  public ApiSecurityRole(long roleID, String roleName) {
    this.roleID = roleID;
    this.roleName = roleName;
  }

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
}