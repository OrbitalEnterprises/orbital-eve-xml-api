package enterprises.orbital.impl.evexmlapi.eve;

import java.util.Date;

import enterprises.orbital.evexmlapi.eve.IEmploymentHistory;

public class ApiEmploymentHistory implements IEmploymentHistory {
  private long recordID;
  private long corporationID;
  private Date startDate;

  public long getRecordID() {
    return recordID;
  }

  public void setRecordID(long recordID) {
    this.recordID = recordID;
  }

  public long getCorporationID() {
    return corporationID;
  }

  public void setCorporationID(long corporationID) {
    this.corporationID = corporationID;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }
}