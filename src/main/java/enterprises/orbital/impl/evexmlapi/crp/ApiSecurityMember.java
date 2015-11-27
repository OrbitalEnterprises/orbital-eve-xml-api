package enterprises.orbital.impl.evexmlapi.crp;

import java.util.HashSet;
import java.util.Set;

import enterprises.orbital.evexmlapi.crp.IMemberSecurity;
import enterprises.orbital.evexmlapi.crp.ISecurityRole;
import enterprises.orbital.evexmlapi.crp.ISecurityTitle;

public class ApiSecurityMember implements IMemberSecurity {
  private long                      characterID;
  private String                    name;
  private final Set<ISecurityRole>  roles                 = new HashSet<ISecurityRole>();
  private final Set<ISecurityRole>  grantableRoles        = new HashSet<ISecurityRole>();
  private final Set<ISecurityRole>  rolesAtHQ             = new HashSet<ISecurityRole>();
  private final Set<ISecurityRole>  grantableRolesAtHQ    = new HashSet<ISecurityRole>();
  private final Set<ISecurityRole>  rolesAtBase           = new HashSet<ISecurityRole>();
  private final Set<ISecurityRole>  grantableRolesAtBase  = new HashSet<ISecurityRole>();
  private final Set<ISecurityRole>  rolesAtOther          = new HashSet<ISecurityRole>();
  private final Set<ISecurityRole>  grantableRolesAtOther = new HashSet<ISecurityRole>();
  private final Set<ISecurityTitle> titles                = new HashSet<ISecurityTitle>();

  @Override
  public long getCharacterID() {
    return characterID;
  }

  public void setCharacterID(long characterID) {
    this.characterID = characterID;
  }

  @Override
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void addSecurityRoleBag(SecurityRoleOrTitleBag securityRoleBag) {
    String bagName = securityRoleBag.getName();
    if (bagName.equals("roles"))
      addSecurityRoles(roles, securityRoleBag);
    else if (bagName.equals("grantableRoles"))
      addSecurityRoles(grantableRoles, securityRoleBag);
    else if (bagName.equals("rolesAtHQ"))
      addSecurityRoles(rolesAtHQ, securityRoleBag);
    else if (bagName.equals("grantableRolesAtHQ"))
      addSecurityRoles(grantableRolesAtHQ, securityRoleBag);
    else if (bagName.equals("rolesAtBase"))
      addSecurityRoles(rolesAtBase, securityRoleBag);
    else if (bagName.equals("grantableRolesAtBase"))
      addSecurityRoles(grantableRolesAtBase, securityRoleBag);
    else if (bagName.equals("rolesAtOther"))
      addSecurityRoles(rolesAtOther, securityRoleBag);
    else if (bagName.equals("grantableRolesAtOther"))
      addSecurityRoles(grantableRolesAtOther, securityRoleBag);
    else if (bagName.equals("titles"))
      for (SecurityRoleOrTitle securityRoleOrTitle : securityRoleBag.getSecurityRoles())
        titles.add(securityRoleOrTitle.getTitle());
    else
      throw new RuntimeException("Unknown roleOrTitleBag name");
  }

  private void addSecurityRoles(Set<ISecurityRole> roleSet, SecurityRoleOrTitleBag securityRoleBag) {
    for (SecurityRoleOrTitle securityRoleOrTitle : securityRoleBag.getSecurityRoles())
      roleSet.add(securityRoleOrTitle.getRole());
  }

  @Override
  public Set<ISecurityRole> getRoles() {
    return roles;
  }

  @Override
  public Set<ISecurityRole> getGrantableRoles() {
    return grantableRoles;
  }

  @Override
  public Set<ISecurityRole> getRolesAtHQ() {
    return rolesAtHQ;
  }

  @Override
  public Set<ISecurityRole> getGrantableRolesAtHQ() {
    return grantableRolesAtHQ;
  }

  @Override
  public Set<ISecurityRole> getRolesAtBase() {
    return rolesAtBase;
  }

  @Override
  public Set<ISecurityRole> getGrantableRolesAtBase() {
    return grantableRolesAtBase;
  }

  @Override
  public Set<ISecurityRole> getRolesAtOther() {
    return rolesAtOther;
  }

  @Override
  public Set<ISecurityRole> getGrantableRolesAtOther() {
    return grantableRolesAtOther;
  }

  @Override
  public Set<ISecurityTitle> getTitles() {
    return titles;
  }
}
