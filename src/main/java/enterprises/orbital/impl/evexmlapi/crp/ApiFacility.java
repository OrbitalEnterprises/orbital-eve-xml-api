package enterprises.orbital.impl.evexmlapi.crp;

import enterprises.orbital.evexmlapi.crp.IFacility;

public class ApiFacility implements IFacility {
  private long   facilityID;
  private int    typeID;
  private String typeName;
  private int    solarSystemID;
  private String solarSystemName;
  private int    regionID;
  private String regionName;
  private int    starbaseModifier;
  private double tax;

  public long getFacilityID() {
    return facilityID;
  }

  public void setFacilityID(long facilityID) {
    this.facilityID = facilityID;
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

  public int getRegionID() {
    return regionID;
  }

  public void setRegionID(int regionID) {
    this.regionID = regionID;
  }

  public String getRegionName() {
    return regionName;
  }

  public void setRegionName(String regionName) {
    this.regionName = regionName;
  }

  public int getStarbaseModifier() {
    return starbaseModifier;
  }

  public void setStarbaseModifier(int starbaseModifier) {
    this.starbaseModifier = starbaseModifier;
  }

  public double getTax() {
    return tax;
  }

  public void setTax(double tax) {
    this.tax = tax;
  }

}