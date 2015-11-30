package enterprises.orbital.impl.evexmlapi.chr;

import java.util.Date;

import enterprises.orbital.evexmlapi.chr.IPlanetaryColony;

public class ApiPlanetaryColony implements IPlanetaryColony {
  private int    solarSystemID;
  private String solarSystemName;
  private long   planetID;
  private String planetName;
  private int    planetTypeID;
  private String planetTypeName;
  private long   ownerID;
  private String ownerName;
  private Date   lastUpdate;
  private int    upgradeLevel;
  private int    numberOfPins;

  public int getSolarSystemID() {
    return solarSystemID;
  }

  public void setSolarSystemID(int solarSystemID) {
    this.solarSystemID = solarSystemID;
  }

  public String getSolarSystemName() {
    return solarSystemName;
  }

  public void setSolarSystemName(String solarSystemName) {
    this.solarSystemName = solarSystemName;
  }

  public long getPlanetID() {
    return planetID;
  }

  public void setPlanetID(long planetID) {
    this.planetID = planetID;
  }

  public String getPlanetName() {
    return planetName;
  }

  public void setPlanetName(String planetName) {
    this.planetName = planetName;
  }

  public int getPlanetTypeID() {
    return planetTypeID;
  }

  public void setPlanetTypeID(int planetTypeID) {
    this.planetTypeID = planetTypeID;
  }

  public String getPlanetTypeName() {
    return planetTypeName;
  }

  public void setPlanetTypeName(String planetTypeName) {
    this.planetTypeName = planetTypeName;
  }

  public long getOwnerID() {
    return ownerID;
  }

  public void setOwnerID(long ownerID) {
    this.ownerID = ownerID;
  }

  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }

  public Date getLastUpdate() {
    return lastUpdate;
  }

  public void setLastUpdate(Date lastUpdate) {
    this.lastUpdate = lastUpdate;
  }

  public int getUpgradeLevel() {
    return upgradeLevel;
  }

  public void setUpgradeLevel(int upgradeLevel) {
    this.upgradeLevel = upgradeLevel;
  }

  public int getNumberOfPins() {
    return numberOfPins;
  }

  public void setNumberOfPins(int numberOfPins) {
    this.numberOfPins = numberOfPins;
  }

}