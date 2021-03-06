package enterprises.orbital.evexmlapi.crp;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(
    as = IMemberTracking.class)
public interface IMemberTracking {
  public String getBase();

  public long getBaseID();

  public long getCharacterID();

  public long getGrantableRoles();

  public String getLocation();

  public long getLocationID();

  public Date getLogoffDateTime();

  public Date getLogonDateTime();

  public String getName();

  public long getRoles();

  public String getShipType();

  public int getShipTypeID();

  public Date getStartDateTime();

  public String getTitle();
}
