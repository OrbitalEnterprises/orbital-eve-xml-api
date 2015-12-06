package enterprises.orbital.evexmlapi.chr;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IPlanetaryPin.class)
public interface IPlanetaryPin {
  public long getPinID();

  public int getTypeID();

  public String getTypeName();

  public int getSchematicID();

  public Date getLastLaunchTime();

  public int getCycleTime();

  public int getQuantityPerCycle();

  public Date getInstallTime();

  public Date getExpiryTime();

  public int getContentTypeID();

  public String getContentTypeName();

  public int getContentQuantity();

  public double getLongitude();

  public double getLatitude();
}
