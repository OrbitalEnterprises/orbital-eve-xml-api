package enterprises.orbital.evexmlapi.crp;

public interface IOutpostServiceDetail {
  public long getStationID();

  public String getServiceName();

  public long getOwnerID();

  public double getMinStanding();

  public double getSurchargePerBadStanding();

  public double getDiscountPerGoodStanding();
}
