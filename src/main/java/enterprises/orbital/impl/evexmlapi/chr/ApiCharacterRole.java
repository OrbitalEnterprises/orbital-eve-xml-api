package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.evexmlapi.chr.CharacterRoleCategory;
import enterprises.orbital.evexmlapi.chr.ICharacterRole;

public class ApiCharacterRole implements ICharacterRole {
  private String roleCategory;
  private long   roleID;
  private String roleName;

  @Override
  public CharacterRoleCategory getRoleCategory() {
    switch (roleCategory) {
    case "corporationRoles":
      return CharacterRoleCategory.CORPORATION;
    case "corporationRolesAtHQ":
      return CharacterRoleCategory.CORPORATION_AT_HQ;
    case "corporationRolesAtBase":
      return CharacterRoleCategory.CORPORATION_AT_BASE;
    case "corporationRolesAtOther":
      return CharacterRoleCategory.CORPORATION_AT_OTHER;
    }
    return null;
  }

  public void setRoleCategory(String roleCategory) {
    this.roleCategory = roleCategory;
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
