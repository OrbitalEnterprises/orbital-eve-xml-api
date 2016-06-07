package enterprises.orbital.evexmlapi.act;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = ICharacter.class)
public interface ICharacter {
  public String getName();

  public long getCharacterID();

  public String getCorporationName();

  public long getCorporationID();

  public String getAllianceName();

  public long getAllianceID();

  public String getFactionName();

  public long getFactionID();
}
