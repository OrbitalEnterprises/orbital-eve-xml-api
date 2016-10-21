package enterprises.orbital.impl.evexmlapi.eve;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enterprises.orbital.evexmlapi.eve.ICharacterInfo;
import enterprises.orbital.evexmlapi.eve.IEmploymentHistory;
import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class CharacterInfoResponse extends ApiResponse implements ICharacterInfo {
  private long                           characterID;
  private String                         characterName;
  private String                         race;
  private String                         bloodline;
  private BigDecimal                     accountBalance;
  private int                            skillPoints;
  private String                         shipName;
  private int                            shipTypeID;
  private String                         shipTypeName;
  private long                           corporationID;
  private String                         corporation;
  private Date                           corporationDate;
  private long                           allianceID;
  private String                         alliance;
  private Date                           allianceDate;
  private String                         lastKnownLocation;
  private double                         securityStatus;
  private final List<IEmploymentHistory> employmentHistory = new ArrayList<IEmploymentHistory>();

  public void addEmploymentHistory(
                                   ApiEmploymentHistory h) {
    employmentHistory.add(h);
  }

  @Override
  public List<IEmploymentHistory> getEmploymentHistory() {
    return employmentHistory;
  }

  @Override
  public long getCharacterID() {
    return characterID;
  }

  public void setCharacterID(
                             long characterID) {
    this.characterID = characterID;
  }

  @Override
  public String getCharacterName() {
    return characterName;
  }

  public void setCharacterName(
                               String characterName) {
    this.characterName = characterName;
  }

  @Override
  public String getRace() {
    return race;
  }

  public void setRace(
                      String race) {
    this.race = race;
  }

  @Override
  public String getBloodline() {
    return bloodline;
  }

  public void setBloodline(
                           String bloodline) {
    this.bloodline = bloodline;
  }

  @Override
  public BigDecimal getAccountBalance() {
    return accountBalance;
  }

  public void setAccountBalance(
                                BigDecimal accountBalance) {
    this.accountBalance = accountBalance;
  }

  @Override
  public int getSkillPoints() {
    return skillPoints;
  }

  public void setSkillPoints(
                             int skillPoints) {
    this.skillPoints = skillPoints;
  }

  @Override
  public String getShipName() {
    return shipName;
  }

  public void setShipName(
                          String shipName) {
    this.shipName = shipName;
  }

  @Override
  public int getShipTypeID() {
    return shipTypeID;
  }

  public void setShipTypeID(
                            int shipTypeID) {
    this.shipTypeID = shipTypeID;
  }

  @Override
  public String getShipTypeName() {
    return shipTypeName;
  }

  public void setShipTypeName(
                              String shipTypeName) {
    this.shipTypeName = shipTypeName;
  }

  @Override
  public long getCorporationID() {
    return corporationID;
  }

  public void setCorporationID(
                               long corporationID) {
    this.corporationID = corporationID;
  }

  @Override
  public String getCorporation() {
    return corporation;
  }

  public void setCorporation(
                             String corporation) {
    this.corporation = corporation;
  }

  @Override
  public Date getCorporationDate() {
    return corporationDate;
  }

  public void setCorporationDate(
                                 Date corporationDate) {
    this.corporationDate = corporationDate;
  }

  @Override
  public long getAllianceID() {
    return allianceID;
  }

  public void setAllianceID(
                            Long allianceID) {
    this.allianceID = allianceID;
  }

  @Override
  public String getAlliance() {
    return alliance;
  }

  public void setAlliance(
                          String alliance) {
    this.alliance = alliance;
  }

  @Override
  public Date getAllianceDate() {
    return allianceDate;
  }

  public void setAllianceDate(
                              Date allianceDate) {
    this.allianceDate = allianceDate;
  }

  @Override
  public String getLastKnownLocation() {
    return lastKnownLocation;
  }

  public void setLastKnownLocation(
                                   String lastKnownLocation) {
    this.lastKnownLocation = lastKnownLocation;
  }

  @Override
  public double getSecurityStatus() {
    return securityStatus;
  }

  public void setSecurityStatus(
                                double securityStatus) {
    this.securityStatus = securityStatus;
  }
}