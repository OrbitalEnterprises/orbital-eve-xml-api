package enterprises.orbital.evexmlapi.crp;

import java.util.Date;

public interface IMemberTracking {
  public String getBase();

  public int getBaseID();

  public long getCharacterID();

  public long getGrantableRoles();

  public String getLocation();

  public int getLocationID();

  public Date getLogoffDateTime();

  public Date getLogonDateTime();

  public String getName();

  public long getRoles();

  public String getShipType();

  public int getShipTypeID();

  public Date getStartDateTime();

  public String getTitle();
}
