package enterprises.orbital.evexmlapi.shared;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IKillVictim.class)
public interface IKillVictim {
  public long getAllianceID();

  public String getAllianceName();

  public long getCharacterID();

  public String getCharacterName();

  public long getCorporationID();

  public String getCorporationName();

  public long getDamageTaken();

  public long getFactionID();

  public String getFactionName();

  public int getShipTypeID();
}
