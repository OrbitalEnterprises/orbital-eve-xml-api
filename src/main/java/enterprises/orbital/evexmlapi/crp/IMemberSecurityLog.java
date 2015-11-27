package enterprises.orbital.evexmlapi.crp;

import java.util.Collection;
import java.util.Date;

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
