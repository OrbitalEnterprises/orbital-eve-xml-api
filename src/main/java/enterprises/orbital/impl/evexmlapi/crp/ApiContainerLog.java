package enterprises.orbital.impl.evexmlapi.crp;

import java.util.Date;

import enterprises.orbital.evexmlapi.crp.IContainerLog;

public class ApiContainerLog implements IContainerLog {
  private Date   logTime;
  private long   itemID;
  private int    itemTypeID;
  private long   actorID;
  private String actorName;
  private byte   flag;
  private long   locationID;
  private String action;
  private String passwordType;
  private int    typeID;
  private long   quantity;
  private String oldConfiguration;
  private String newConfiguration;

  @Override
  public Date getLogTime() {
    return logTime;
  }

  public void setLogTime(
                         Date logTime) {
    this.logTime = logTime;
  }

  @Override
  public long getItemID() {
    return itemID;
  }

  public void setItemID(
                        long itemID) {
    this.itemID = itemID;
  }

  @Override
  public int getItemTypeID() {
    return itemTypeID;
  }

  public void setItemTypeID(
                            int itemTypeID) {
    this.itemTypeID = itemTypeID;
  }

  @Override
  public long getActorID() {
    return actorID;
  }

  public void setActorID(
                         long actorID) {
    this.actorID = actorID;
  }

  @Override
  public String getActorName() {
    return actorName;
  }

  public void setActorName(
                           String actorName) {
    this.actorName = actorName;
  }

  @Override
  public byte getFlag() {
    return flag;
  }

  public void setFlag(
                      byte flag) {
    this.flag = flag;
  }

  @Override
  public long getLocationID() {
    return locationID;
  }

  public void setLocationID(
                            long locationID) {
    this.locationID = locationID;
  }

  @Override
  public String getAction() {
    return action;
  }

  public void setAction(
                        String action) {
    this.action = action;
  }

  @Override
  public String getPasswordType() {
    return passwordType;
  }

  public void setPasswordType(
                              String passwordType) {
    this.passwordType = passwordType;
  }

  @Override
  public int getTypeID() {
    return typeID;
  }

  public void setTypeID(
                        int typeID) {
    this.typeID = typeID;
  }

  @Override
  public long getQuantity() {
    return quantity;
  }

  public void setQuantity(
                          long quantity) {
    this.quantity = quantity;
  }

  @Override
  public String getOldConfiguration() {
    return oldConfiguration;
  }

  public void setOldConfiguration(
                                  String oldConfiguration) {
    this.oldConfiguration = oldConfiguration;
  }

  @Override
  public String getNewConfiguration() {
    return newConfiguration;
  }

  public void setNewConfiguration(
                                  String newConfiguration) {
    this.newConfiguration = newConfiguration;
  }
}
