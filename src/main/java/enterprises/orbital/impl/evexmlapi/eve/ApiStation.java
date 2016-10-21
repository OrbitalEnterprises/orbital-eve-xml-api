package enterprises.orbital.impl.evexmlapi.eve;

import enterprises.orbital.evexmlapi.eve.IConquerableStation;

public class ApiStation implements IConquerableStation {
  private long   stationID;
  private String stationName;
  private int    stationTypeID;
  private long   solarSystemID;
  private long   corporationID;
  private String corporationName;
  private long   x;
  private long   y;
  private long   z;

  @Override
  public long getStationID() {
    return stationID;
  }

  public void setStationID(
                           long stationID) {
    this.stationID = stationID;
  }

  @Override
  public String getStationName() {
    return stationName;
  }

  public void setStationName(
                             String stationName) {
    this.stationName = stationName;
  }

  @Override
  public int getStationTypeID() {
    return stationTypeID;
  }

  public void setStationTypeID(
                               int stationTypeID) {
    this.stationTypeID = stationTypeID;
  }

  @Override
  public long getSolarSystemID() {
    return solarSystemID;
  }

  public void setSolarSystemID(
                               long solarSystemID) {
    this.solarSystemID = solarSystemID;
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
  public String getCorporationName() {
    return corporationName;
  }

  public void setCorporationName(
                                 String corporationName) {
    this.corporationName = corporationName;
  }

  @Override
  public long getX() {
    return x;
  }

  public void setX(
                   long x) {
    this.x = x;
  }

  @Override
  public long getY() {
    return y;
  }

  public void setY(
                   long y) {
    this.y = y;
  }

  @Override
  public long getZ() {
    return z;
  }

  public void setZ(
                   long z) {
    this.z = z;
  }

}
