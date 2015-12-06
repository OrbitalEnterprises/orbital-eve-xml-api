package enterprises.orbital.evexmlapi.crp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IFacility.class)
public interface IFacility {
  public long getFacilityID();

  public int getTypeID();

  public String getTypeName();

  public int getSolarSystemID();

  public String getSolarSystemName();

  public int getRegionID();

  public String getRegionName();

  public int getStarbaseModifier();

  public double getTax();

}
