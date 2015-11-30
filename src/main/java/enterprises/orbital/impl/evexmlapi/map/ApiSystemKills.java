package enterprises.orbital.impl.evexmlapi.map;

import enterprises.orbital.evexmlapi.map.ISystemKills;

public class ApiSystemKills implements ISystemKills {
  private int solarSystemID;
  private int shipKills;
  private int factionKills;
  private int podKills;

  @Override
  public int getSolarSystemID() {
    return solarSystemID;
  }

  public void setSolarSystemID(int solarSystemID) {
    this.solarSystemID = solarSystemID;
  }

  @Override
  public int getShipKills() {
    return shipKills;
  }

  public void setShipKills(int shipKills) {
    this.shipKills = shipKills;
  }

  @Override
  public int getFactionKills() {
    return factionKills;
  }

  public void setFactionKills(int factionKills) {
    this.factionKills = factionKills;
  }

  @Override
  public int getPodKills() {
    return podKills;
  }

  public void setPodKills(int podKills) {
    this.podKills = podKills;
  }
}
