package enterprises.orbital.evexmlapi.eve;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IEmploymentHistory.class)
public interface IEmploymentHistory {
  public long getRecordID();

  public long getCorporationID();

  public Date getStartDate();
}
