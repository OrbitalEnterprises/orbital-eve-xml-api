package enterprises.orbital.impl.evexmlapi.crp;

import java.util.ArrayList;
import java.util.Collection;

import enterprises.orbital.evexmlapi.crp.IRole;
import enterprises.orbital.evexmlapi.crp.ITitle;

public class ApiTitle implements ITitle {
  private long                    titleID;
  private String                  titleName;
  private final Collection<IRole> roles                 = new ArrayList<IRole>();
  private final Collection<IRole> grantableRoles        = new ArrayList<IRole>();
  private final Collection<IRole> rolesAtHQ             = new ArrayList<IRole>();
  private final Collection<IRole> grantableRolesAtHQ    = new ArrayList<IRole>();
  private final Collection<IRole> rolesAtBase           = new ArrayList<IRole>();
  private final Collection<IRole> grantableRolesAtBase  = new ArrayList<IRole>();
  private final Collection<IRole> rolesAtOther          = new ArrayList<IRole>();
  private final Collection<IRole> grantableRolesAtOther = new ArrayList<IRole>();

  @Override
  public long getTitleID() {
    return titleID;
  }

  public void setTitleID(long titleID) {
    this.titleID = titleID;
  }

  @Override
  public String getTitleName() {
    return titleName;
  }

  public void setTitleName(String titleName) {
    this.titleName = titleName;
  }

  @Override
  public Collection<IRole> getRoles() {
    return roles;
  }

  @Override
  public Collection<IRole> getGrantableRoles() {
    return grantableRoles;
  }

  @Override
  public Collection<IRole> getRolesAtHQ() {
    return rolesAtHQ;
  }

  @Override
  public Collection<IRole> getGrantableRolesAtHQ() {
    return grantableRolesAtHQ;
  }

  @Override
  public Collection<IRole> getRolesAtBase() {
    return rolesAtBase;
  }

  @Override
  public Collection<IRole> getGrantableRolesAtBase() {
    return grantableRolesAtBase;
  }

  @Override
  public Collection<IRole> getRolesAtOther() {
    return rolesAtOther;
  }

  @Override
  public Collection<IRole> getGrantableRolesAtOther() {
    return grantableRolesAtOther;
  }

  public void addRoleBag(RoleBag roleBag) {
    String name = roleBag.getName();
    Collection<IRole> target = null;
    if (name.equals("roles")) {
      target = roles;
    } else if (name.equals("grantableRoles")) {
      target = grantableRoles;
    } else if (name.equals("rolesAtHQ")) {
      target = rolesAtHQ;
    } else if (name.equals("grantableRolesAtHQ")) {
      target = grantableRolesAtHQ;
    } else if (name.equals("rolesAtBase")) {
      target = rolesAtBase;
    } else if (name.equals("grantableRolesAtBase")) {
      target = grantableRolesAtBase;
    } else if (name.equals("rolesAtOther")) {
      target = rolesAtOther;
    } else if (name.equals("grantableRolesAtOther")) {
      target = grantableRolesAtOther;
    } else {
      throw new RuntimeException("unknown role bag type");
    }
    for (ApiRole role : roleBag.getRoles()) {
      target.add(role);
    }
  }
}