package enterprises.orbital.evexmlapi.chr;

import java.util.Date;

public interface IPlanetaryColony {
  public int getSolarSystemID();

  public String getSolarSystemName();

  public long getPlanetID();

  public String getPlanetName();

  public int getPlanetTypeID();

  public String getPlanetTypeName();

  public long getOwnerID();

  public String getOwnerName();

  public Date getLastUpdate();

  public int getUpgradeLevel();

  public int getNumberOfPins();
}
