package enterprises.orbital.impl.evexmlapi.map;

import enterprises.orbital.evexmlapi.map.IFacWarSystem;

public class ApiFacWarSystem implements IFacWarSystem {
  private int     solarSystemID;
  private String  solarSystemName;
  private long    occupyingFactionID;
  private String  occupyingFactionName;
  private long    owningFactionID;
  private String  owningFactionName;
  private boolean contested;

  @Override
  public long getOwningFactionID() {
    return owningFactionID;
  }

  public void setOwningFactionID(
                                 long owningFactionID) {
    this.owningFactionID = owningFactionID;
  }

  @Override
  public String getOwningFactionName() {
    return owningFactionName;
  }

  public void setOwningFactionName(
                                   String owningFactionName) {
    this.owningFactionName = owningFactionName;
  }

  @Override
  public int getSolarSystemID() {
    return solarSystemID;
  }

  public void setSolarSystemID(
                               int solarSystemID) {
    this.solarSystemID = solarSystemID;
  }

  @Override
  public String getSolarSystemName() {
    return solarSystemName;
  }

  public void setSolarSystemName(
                                 String solarSystemName) {
    this.solarSystemName = solarSystemName;
  }

  @Override
  public long getOccupyingFactionID() {
    return occupyingFactionID;
  }

  public void setOccupyingFactionID(
                                    long occupyingFactionID) {
    this.occupyingFactionID = occupyingFactionID;
  }

  @Override
  public String getOccupyingFactionName() {
    return occupyingFactionName;
  }

  public void setOccupyingFactionName(
                                      String occupyingFactionName) {
    this.occupyingFactionName = occupyingFactionName;
  }

  @Override
  public boolean isContested() {
    return contested;
  }

  public void setContested(
                           boolean contested) {
    this.contested = contested;
  }
}
