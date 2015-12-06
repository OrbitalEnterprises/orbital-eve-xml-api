package enterprises.orbital.evexmlapi.crp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = ISecurityRole.class)
public interface ISecurityRole {
  public long getRoleID();

  public String getRoleName();
}
