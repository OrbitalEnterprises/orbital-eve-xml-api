package enterprises.orbital.impl.evexmlapi.shared;

import enterprises.orbital.evexmlapi.shared.IKillAttacker;

public class ApiKillAttacker implements IKillAttacker {
  private long    characterID;
  private String  characterName;
  private long    corporationID;
  private String  corporationName;
  private long    allianceID;
  private String  allianceName;
  private int     factionID;
  private String  factionName;
  private double  securityStatus;
  private int     damageDone;
  private boolean finalBlow;
  private int     weaponTypeID;
  private int     shipTypeID;

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
  public int getFactionID() {
    return factionID;
  }

  public void setFactionID(int factionID) {
    this.factionID = factionID;
  }

  @Override
  public String getFactionName() {
    return factionName;
  }

  public void setFactionName(String factionName) {
    this.factionName = factionName;
  }

  @Override
  public double getSecurityStatus() {
    return securityStatus;
  }

  public void setSecurityStatus(double securityStatus) {
    this.securityStatus = securityStatus;
  }

  @Override
  public int getDamageDone() {
    return damageDone;
  }

  public void setDamageDone(int damageDone) {
    this.damageDone = damageDone;
  }

  @Override
  public boolean isFinalBlow() {
    return finalBlow;
  }

  public void setFinalBlow(boolean finalBlow) {
    this.finalBlow = finalBlow;
  }

  @Override
  public int getWeaponTypeID() {
    return weaponTypeID;
  }

  public void setWeaponTypeID(int weaponTypeID) {
    this.weaponTypeID = weaponTypeID;
  }

  @Override
  public int getShipTypeID() {
    return shipTypeID;
  }

  public void setShipTypeID(int shipTypeID) {
    this.shipTypeID = shipTypeID;
  }
}