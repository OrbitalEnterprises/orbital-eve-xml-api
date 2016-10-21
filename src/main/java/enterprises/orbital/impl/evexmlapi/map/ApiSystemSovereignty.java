package enterprises.orbital.impl.evexmlapi.map;

import enterprises.orbital.evexmlapi.map.ISystemSovereignty;

public class ApiSystemSovereignty implements ISystemSovereignty {
  private int    solarSystemID;
  private long   allianceID;
  private long   corporationID;
  private long   factionID;
  private String solarSystemName;

  @Override
  public int getSolarSystemID() {
    return solarSystemID;
  }

  public void setSolarSystemID(
                               int solarSystemID) {
    this.solarSystemID = solarSystemID;
  }

  @Override
  public long getAllianceID() {
    return allianceID;
  }

  public void setAllianceID(
                            long allianceID) {
    this.allianceID = allianceID;
  }

  @Override
  public long getCorporationID() {
    return corporationID;
  }

  public void setCorporationID(
                               long corporationID) {
    this.corporationID = corporationID;
  }

  @Override
  public long getFactionID() {
    return factionID;
  }

  public void setFactionID(
                           long factionID) {
    this.factionID = factionID;
  }

  @Override
  public String getSolarSystemName() {
    return solarSystemName;
  }

  public void setSolarSystemName(
                                 String solarSystemName) {
    this.solarSystemName = solarSystemName;
  }
}
