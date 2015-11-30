package enterprises.orbital.impl.evexmlapi.chr;

import java.util.Date;

import enterprises.orbital.evexmlapi.chr.ICharacterMedal;
import enterprises.orbital.impl.evexmlapi.shared.Medal;

public class CharacterMedal extends Medal implements ICharacterMedal {
  private String reason;
  private String status;
  private long   issuerID;
  private Date   issued;
  private long   corporationID;

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

  @Override
  public long getCorporationID() {
    return corporationID;
  }

  public void setCorporationID(long corporationID) {
    this.corporationID = corporationID;
  }
}