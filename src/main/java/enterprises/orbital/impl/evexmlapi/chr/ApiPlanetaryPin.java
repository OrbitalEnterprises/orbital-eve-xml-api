package enterprises.orbital.impl.evexmlapi.chr;

import java.util.Date;

import enterprises.orbital.evexmlapi.chr.IPlanetaryPin;

public class ApiPlanetaryPin implements IPlanetaryPin {
  private long   pinID;
  private int    typeID;
  private String typeName;
  private int    schematicID;
  private Date   lastLaunchTime;
  private int    cycleTime;
  private int    quantityPerCycle;
  private Date   installTime;
  private Date   expiryTime;
  private int    contentTypeID;
  private String contentTypeName;
  private int    contentQuantity;
  private double longitude;
  private double latitude;

  public long getPinID() {
    return pinID;
  }

  public void setPinID(long pinID) {
    this.pinID = pinID;
  }

  public int getTypeID() {
    return typeID;
  }

  public void setTypeID(int typeID) {
    this.typeID = typeID;
  }

  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  public int getSchematicID() {
    return schematicID;
  }

  public void setSchematicID(int schematicID) {
    this.schematicID = schematicID;
  }

  public Date getLastLaunchTime() {
    return lastLaunchTime;
  }

  public void setLastLaunchTime(Date lastLaunchTime) {
    this.lastLaunchTime = lastLaunchTime;
  }

  public int getCycleTime() {
    return cycleTime;
  }

  public void setCycleTime(int cycleTime) {
    this.cycleTime = cycleTime;
  }

  public int getQuantityPerCycle() {
    return quantityPerCycle;
  }

  public void setQuantityPerCycle(int quantityPerCycle) {
    this.quantityPerCycle = quantityPerCycle;
  }

  public Date getInstallTime() {
    return installTime;
  }

  public void setInstallTime(Date installTime) {
    this.installTime = installTime;
  }

  public Date getExpiryTime() {
    return expiryTime;
  }

  public void setExpiryTime(Date expiryTime) {
    this.expiryTime = expiryTime;
  }

  public int getContentTypeID() {
    return contentTypeID;
  }

  public void setContentTypeID(int contentTypeID) {
    this.contentTypeID = contentTypeID;
  }

  public String getContentTypeName() {
    return contentTypeName;
  }

  public void setContentTypeName(String contentTypeName) {
    this.contentTypeName = contentTypeName;
  }

  public int getContentQuantity() {
    return contentQuantity;
  }

  public void setContentQuantity(int contentQuantity) {
    this.contentQuantity = contentQuantity;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

}