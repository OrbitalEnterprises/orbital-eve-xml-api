package enterprises.orbital.evexmlapi.chr;

import java.util.Date;

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
