package enterprises.orbital.evexmlapi.map;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IJump.class)
public interface IJump {
  public int getShipJumps();

  public int getSolarSystemID();
}
