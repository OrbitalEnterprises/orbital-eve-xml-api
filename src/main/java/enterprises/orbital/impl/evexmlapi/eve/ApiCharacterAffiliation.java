package enterprises.orbital.impl.evexmlapi.eve;

import enterprises.orbital.evexmlapi.eve.ICharacterAffiliation;

public class ApiCharacterAffiliation implements ICharacterAffiliation {
  private long   characterID;
  private String characterName;
  private long   corporationID;
  private String corporationName;
  private long   allianceID;
  private String allianceName;
  private long   factionID;
  private String factionName;

  @Override
  public long getCharacterID() {
    return characterID;
  }

  public void setCharacterID(long characterID) {
    this.characterID = characterID;
  }

  @Override
  public String getCharacterName() {
    return characterName;
  }

  public void setCharacterName(String characterName) {
    this.characterName = characterName;
  }

  @Override
  public long getCorporationID() {
    return corporationID;
  }

  public void setCorporationID(long corporationID) {
    this.corporationID = corporationID;
  }

  @Override
  public String getCorporationName() {
    return corporationName;
  }

  public void setCorporationName(String corporationName) {
    this.corporationName = corporationName;
  }

  @Override
  public long getAllianceID() {
    return allianceID;
  }

  public void setAllianceID(long allianceID) {
    this.allianceID = allianceID;
  }

  @Override
  public String getAllianceName() {
    return allianceName;
  }

  public void setAllianceName(String allianceName) {
    this.allianceName = allianceName;
  }

  @Override
  public long getFactionID() {
    return factionID;
  }

  public void setFactionID(long factionID) {
    this.factionID = factionID;
  }

  @Override
  public String getFactionName() {
    return factionName;
  }

  public void setFactionName(String factionName) {
    this.factionName = factionName;
  }

}
