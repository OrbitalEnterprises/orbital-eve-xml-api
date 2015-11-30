package enterprises.orbital.impl.evexmlapi.act;

import enterprises.orbital.evexmlapi.act.ICharacter;

public class ApiCharacter implements ICharacter {
  private String name;
  private String characterName;
  private long   characterID;
  private String corporationName;
  private long   corporationID;
  private String allianceName;
  private long   allianceID;
  private String factionName;
  private long   factionID;

  public String getName() {
    if (name != null) return name;
    return characterName;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getCharacterName() {
    if (name != null) return name;
    return characterName;
  }

  public void setCharacterName(String characterName) {
    this.characterName = characterName;
  }

  public long getCharacterID() {
    return characterID;
  }

  public void setCharacterID(long characterID) {
    this.characterID = characterID;
  }

  public String getCorporationName() {
    return corporationName;
  }

  public void setCorporationName(String corporationName) {
    this.corporationName = corporationName;
  }

  public long getCorporationID() {
    return corporationID;
  }

  public void setCorporationID(long corporationID) {
    this.corporationID = corporationID;
  }

  public String getAllianceName() {
    return allianceName;
  }

  public long getAllianceID() {
    return allianceID;
  }

  public String getFactionName() {
    return factionName;
  }

  public long getFactionID() {
    return factionID;
  }

  public void setAllianceName(String allianceName) {
    this.allianceName = allianceName;
  }

  public void setAllianceID(long allianceID) {
    this.allianceID = allianceID;
  }

  public void setFactionName(String factionName) {
    this.factionName = factionName;
  }

  public void setFactionID(long factionID) {
    this.factionID = factionID;
  }

}