package enterprises.orbital.evexmlapi.map;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = ISystemKills.class)
public interface ISystemKills {
  public int getFactionKills();

  public int getPodKills();

  public int getShipKills();

  public int getSolarSystemID();
}
