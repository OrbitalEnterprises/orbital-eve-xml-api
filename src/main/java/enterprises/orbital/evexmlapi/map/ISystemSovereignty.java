package enterprises.orbital.evexmlapi.map;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(
    as = ISystemSovereignty.class)
public interface ISystemSovereignty {
  public long getAllianceID();

  public long getCorporationID();

  public long getFactionID();

  public int getSolarSystemID();

  public String getSolarSystemName();
}
