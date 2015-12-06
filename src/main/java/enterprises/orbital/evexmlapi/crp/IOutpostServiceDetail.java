package enterprises.orbital.evexmlapi.crp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IOutpostServiceDetail.class)
public interface IOutpostServiceDetail {
  public long getStationID();

  public String getServiceName();

  public long getOwnerID();

  public double getMinStanding();

  public double getSurchargePerBadStanding();

  public double getDiscountPerGoodStanding();
}
