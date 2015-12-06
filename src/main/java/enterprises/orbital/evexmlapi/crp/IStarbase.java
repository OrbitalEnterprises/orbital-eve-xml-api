package enterprises.orbital.evexmlapi.crp;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IStarbase.class)
public interface IStarbase {
  public long getItemID();

  public int getLocationID();

  public int getMoonID();

  public Date getOnlineTimestamp();

  public int getState();

  public Date getStateTimestamp();

  public int getTypeID();

  public long getStandingOwnerID();
}
