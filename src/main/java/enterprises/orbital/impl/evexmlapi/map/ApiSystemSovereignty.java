package enterprises.orbital.impl.evexmlapi.map;

import enterprises.orbital.evexmlapi.map.ISystemSovereignty;

public class ApiSystemSovereignty implements ISystemSovereignty {
  private int    solarSystemID;
  private int    allianceID;
  private int    corporationID;
  private int    factionID;
  private String solarSystemName;

  @Override
  public int getSolarSystemID() {
    return solarSystemID;
  }

  public void setSolarSystemID(int solarSystemID) {
    this.solarSystemID = solarSystemID;
  }

  @Override
  public int getAllianceID() {
    return allianceID;
  }

  public void setAllianceID(int allianceID) {
    this.allianceID = allianceID;
  }

  @Override
  public int getCorporationID() {
    return corporationID;
  }

  public void setCorporationID(int corporationID) {
    this.corporationID = corporationID;
  }

  @Override
  public int getFactionID() {
    return factionID;
  }

  public void setFactionID(int factionID) {
    this.factionID = factionID;
  }

  @Override
  public String getSolarSystemName() {
    return solarSystemName;
  }

  public void setSolarSystemName(String solarSystemName) {
    this.solarSystemName = solarSystemName;
  }
}
