package enterprises.orbital.impl.evexmlapi.eve;

import java.util.Date;

import enterprises.orbital.evexmlapi.eve.IMemberCorporation;

public class ApiMemberCorporation implements IMemberCorporation {
  private long corporationID;
  private Date startDate;

  @Override
  public long getCorporationID() {
    return corporationID;
  }

  public void setCorporationID(long corporationID) {
    this.corporationID = corporationID;
  }

  @Override
  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
}