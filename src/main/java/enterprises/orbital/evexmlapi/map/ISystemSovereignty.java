package enterprises.orbital.evexmlapi.map;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = ISystemSovereignty.class)
public interface ISystemSovereignty {
  public int getAllianceID();

  public int getCorporationID();

  public int getFactionID();

  public int getSolarSystemID();

  public String getSolarSystemName();
}
