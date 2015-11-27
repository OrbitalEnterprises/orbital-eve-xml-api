package enterprises.orbital.evexmlapi.crp;

import java.util.Collection;
import java.util.Date;

public interface IStarbaseDetail {
  public int getState();

  public Date getStateTimestamp();

  public Date getOnlineTimestamp();

  public int getUsageFlags();

  public int getDeployFlags();

  public boolean isAllowAllianceMembers();

  public boolean isAllowCorporationMembers();

  public long getUseStandingsFrom();

  public ICombatSetting getOnAggression();

  public ICombatSetting getOnCorporationWar();

  public ICombatSetting getOnStandingDrop();

  public ICombatSetting getOnStatusDrop();

  public Collection<IFuel> getFuelMap();

}
