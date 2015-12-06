package enterprises.orbital.evexmlapi.crp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IRole.class)
public interface IRole {
  public String getRoleDescription();

  public long getRoleID();

  public String getRoleName();
}
