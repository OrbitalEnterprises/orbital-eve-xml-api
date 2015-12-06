package enterprises.orbital.evexmlapi.eve;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IConquerableStation.class)
public interface IConquerableStation {
  public int getCorporationID();

  public String getCorporationName();

  public long getSolarSystemID();

  public long getStationID();

  public String getStationName();

  public int getStationTypeID();

  public long getX();

  public long getY();

  public long getZ();

}
