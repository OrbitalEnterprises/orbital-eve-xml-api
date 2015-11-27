package enterprises.orbital.impl.evexmlapi.crp;

import java.util.Date;

import enterprises.orbital.evexmlapi.crp.IMemberMedal;

public class MemberMedal implements IMemberMedal {
  private int    medalID;
  private long   characterID;
  private String reason;
  private String status;
  private long   issuerID;
  private Date   issued;

  @Override
  public int getMedalID() {
    return medalID;
  }

  public void setMedalID(int medalID) {
    this.medalID = medalID;
  }

  @Override
  public long getCharacterID() {
    return characterID;
  }

  public void setCharacterID(long characterID) {
    this.characterID = characterID;
  }

  @Override
  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  @Override
  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public boolean isPublic() {
    return status.equals("public");
  }

  @Override
  public long getIssuerID() {
    return issuerID;
  }

  public void setIssuerID(long issuerID) {
    this.issuerID = issuerID;
  }

  @Override
  public Date getIssued() {
    return issued;
  }

  public void setIssued(Date issued) {
    this.issued = issued;
  }
}