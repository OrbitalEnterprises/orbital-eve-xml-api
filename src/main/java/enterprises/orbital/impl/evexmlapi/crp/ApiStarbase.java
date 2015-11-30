package enterprises.orbital.impl.evexmlapi.crp;

import java.util.Date;

import enterprises.orbital.evexmlapi.crp.IStarbase;

public class ApiStarbase implements IStarbase {
  private long itemID;
  private int  typeID;
  private int  locationID;
  private int  moonID;
  private int  state;
  private Date stateTimestamp;
  private Date onlineTimestamp;
  private long standingOwnerID;

  @Override
  public long getStandingOwnerID() {
    return standingOwnerID;
  }

  public void setStandingOwnerID(long standingOwnerID) {
    this.standingOwnerID = standingOwnerID;
  }

  @Override
  public long getItemID() {
    return itemID;
  }

  public void setItemID(long itemID) {
    this.itemID = itemID;
  }

  @Override
  public int getTypeID() {
    return typeID;
  }

  public void setTypeID(int typeID) {
    this.typeID = typeID;
  }

  @Override
  public int getLocationID() {
    return locationID;
  }

  public void setLocationID(int locationID) {
    this.locationID = locationID;
  }

  @Override
  public int getMoonID() {
    return moonID;
  }

  public void setMoonID(int moonID) {
    this.moonID = moonID;
  }

  @Override
  public int getState() {
    return state;
  }

  public void setState(int state) {
    this.state = state;
  }

  public ApiStarbaseState getStarbaseState() {
    return ApiStarbaseState.values()[state];
  }

  @Override
  public Date getStateTimestamp() {
    return stateTimestamp;
  }

  public void setStateTimestamp(Date stateTimestamp) {
    this.stateTimestamp = stateTimestamp;
  }

  @Override
  public Date getOnlineTimestamp() {
    return onlineTimestamp;
  }

  public void setOnlineTimestamp(Date onlineTimestamp) {
    this.onlineTimestamp = onlineTimestamp;
  }

  @Override
  public String toString() {
    return "ApiStarbase [itemID=" + itemID + ", typeID=" + typeID + ", locationID=" + locationID + ", moonID=" + moonID + ", state=" + state
        + ", stateTimestamp=" + stateTimestamp + ", onlineTimestamp=" + onlineTimestamp + ", standingOwnerID=" + standingOwnerID + "]";
  }

}
