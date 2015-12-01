package enterprises.orbital.evexmlapi.eve;

public interface ICharacterAffiliation {
  public long getCharacterID();

  public String getCharacterName();

  public long getCorporationID();

  public String getCorporationName();

  public long getAllianceID();

  public String getAllianceName();

  public long getFactionID();

  public String getFactionName();
}
