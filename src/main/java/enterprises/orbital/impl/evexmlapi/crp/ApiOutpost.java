package enterprises.orbital.impl.evexmlapi.crp;

import enterprises.orbital.evexmlapi.crp.IOutpost;

public class ApiOutpost implements IOutpost {
  private long   stationID;
  private long   ownerID;
  private String stationName;
  private long   solarSystemID;
  private double dockingCostPerShipVolume;
  private double officeRentalCost;
  private int    stationTypeID;
  private double reprocessingEfficiency;
  private double reprocessingStationTake;
  private long   standingOwnerID;
  private long   x;
  private long   y;
  private long   z;

  @Override
  public long getStationID() {
    return stationID;
  }

  public void setStationID(long stationID) {
    this.stationID = stationID;
  }

  @Override
  public long getOwnerID() {
    return ownerID;
  }

  public void setOwnerID(long ownerID) {
    this.ownerID = ownerID;
  }

  @Override
  public String getStationName() {
    return stationName;
  }

  public void setStationName(String stationName) {
    this.stationName = stationName;
  }

  @Override
  public long getSolarSystemID() {
    return solarSystemID;
  }

  public void setSolarSystemID(long solarSystemID) {
    this.solarSystemID = solarSystemID;
  }

  @Override
  public double getDockingCostPerShipVolume() {
    return dockingCostPerShipVolume;
  }

  public void setDockingCostPerShipVolume(double dockingCostPerShipVolume) {
    this.dockingCostPerShipVolume = dockingCostPerShipVolume;
  }

  @Override
  public double getOfficeRentalCost() {
    return officeRentalCost;
  }

  public void setOfficeRentalCost(double officeRentalCost) {
    this.officeRentalCost = officeRentalCost;
  }

  @Override
  public int getStationTypeID() {
    return stationTypeID;
  }

  public void setStationTypeID(int stationTypeID) {
    this.stationTypeID = stationTypeID;
  }

  @Override
  public double getReprocessingEfficiency() {
    return reprocessingEfficiency;
  }

  public void setReprocessingEfficiency(double reprocessingEfficiency) {
    this.reprocessingEfficiency = reprocessingEfficiency;
  }

  @Override
  public double getReprocessingStationTake() {
    return reprocessingStationTake;
  }

  public void setReprocessingStationTake(double reprocessingStationTake) {
    this.reprocessingStationTake = reprocessingStationTake;
  }

  @Override
  public long getStandingOwnerID() {
    return standingOwnerID;
  }

  public void setStandingOwnerID(long standingOwnerID) {
    this.standingOwnerID = standingOwnerID;
  }

  @Override
  public long getX() {
    return x;
  }

  public void setX(long x) {
    this.x = x;
  }

  @Override
  public long getY() {
    return y;
  }

  public void setY(long y) {
    this.y = y;
  }

  @Override
  public long getZ() {
    return z;
  }

  public void setZ(long z) {
    this.z = z;
  }

  @Override
  public String toString() {
    return "ApiOutpost [stationID=" + stationID + ", ownerID=" + ownerID + ", stationName=" + stationName + ", solarSystemID=" + solarSystemID
        + ", dockingCostPerShipVolume=" + dockingCostPerShipVolume + ", officeRentalCost=" + officeRentalCost + ", stationTypeID=" + stationTypeID
        + ", reprocessingEfficiency=" + reprocessingEfficiency + ", reprocessingStationTake=" + reprocessingStationTake + ", standingOwnerID=" + standingOwnerID
        + ", x=" + x + ", y=" + y + ", z=" + z + "]";
  }

}
