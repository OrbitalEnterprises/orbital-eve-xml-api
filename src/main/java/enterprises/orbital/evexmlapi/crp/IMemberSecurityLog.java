package enterprises.orbital.evexmlapi.crp;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IMemberTracking.class)
public interface IMemberSecurityLog {
  public Date getChangeTime();

  public long getCharacterID();

  public String getCharacterName();

  public long getIssuerID();

  public String getIssuerName();

  public Collection<ISecurityRole> getNewRoles();

  public Collection<ISecurityRole> getOldRoles();

  public String getRoleLocationType();
}
