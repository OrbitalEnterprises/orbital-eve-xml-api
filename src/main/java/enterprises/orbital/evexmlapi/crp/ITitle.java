package enterprises.orbital.evexmlapi.crp;

import java.util.Collection;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = ITitle.class)
public interface ITitle {
  public Collection<IRole> getGrantableRoles();

  public Collection<IRole> getGrantableRolesAtBase();

  public Collection<IRole> getGrantableRolesAtHQ();

  public Collection<IRole> getGrantableRolesAtOther();

  public Collection<IRole> getRoles();

  public Collection<IRole> getRolesAtBase();

  public Collection<IRole> getRolesAtHQ();

  public Collection<IRole> getRolesAtOther();

  public long getTitleID();

  public String getTitleName();
}
