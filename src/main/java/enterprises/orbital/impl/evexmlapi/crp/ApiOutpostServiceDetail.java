package enterprises.orbital.impl.evexmlapi.crp;

import enterprises.orbital.evexmlapi.crp.IOutpostServiceDetail;

public class ApiOutpostServiceDetail implements IOutpostServiceDetail {
  private long   stationID;
  private String serviceName;
  private long   ownerID;
  private double minStanding;
  private double surchargePerBadStanding;
  private double discountPerGoodStanding;

  @Override
  public long getStationID() {
    return stationID;
  }

  public void setStationID(long stationID) {
    this.stationID = stationID;
  }

  @Override
  public String getServiceName() {
    return serviceName;
  }

  public void setServiceName(String serviceName) {
    this.serviceName = serviceName;
  }

  @Override
  public long getOwnerID() {
    return ownerID;
  }

  public void setOwnerID(long ownerID) {
    this.ownerID = ownerID;
  }

  @Override
  public double getMinStanding() {
    return minStanding;
  }

  public void setMinStanding(double minStanding) {
    this.minStanding = minStanding;
  }

  @Override
  public double getSurchargePerBadStanding() {
    return surchargePerBadStanding;
  }

  public void setSurchargePerBadStanding(double surchargePerBadStanding) {
    this.surchargePerBadStanding = surchargePerBadStanding;
  }

  @Override
  public double getDiscountPerGoodStanding() {
    return discountPerGoodStanding;
  }

  public void setDiscountPerGoodStanding(double discountPerGoodStanding) {
    this.discountPerGoodStanding = discountPerGoodStanding;
  }

  @Override
  public String toString() {
    return "ApiOutpostServiceDetail [stationID=" + stationID + ", serviceName=" + serviceName + ", ownerID=" + ownerID + ", minStanding=" + minStanding
        + ", surchargePerBadStanding=" + surchargePerBadStanding + ", discountPerGoodStanding=" + discountPerGoodStanding + "]";
  }

}
