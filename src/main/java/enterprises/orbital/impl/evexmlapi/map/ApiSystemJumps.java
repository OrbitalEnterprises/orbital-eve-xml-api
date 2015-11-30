package enterprises.orbital.impl.evexmlapi.map;

import enterprises.orbital.evexmlapi.map.IJump;

public class ApiSystemJumps implements IJump {
  private int solarSystemID;
  private int shipJumps;

  @Override
  public int getSolarSystemID() {
    return solarSystemID;
  }

  public void setSolarSystemID(int solarSystemID) {
    this.solarSystemID = solarSystemID;
  }

  @Override
  public int getShipJumps() {
    return shipJumps;
  }

  public void setShipJumps(int shipJumps) {
    this.shipJumps = shipJumps;
  }
}
