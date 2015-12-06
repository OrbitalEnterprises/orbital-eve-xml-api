package enterprises.orbital.evexmlapi.shared;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IIndustryJob.class)
public interface IIndustryJob {

  public long getJobID();

  public long getInstallerID();

  public String getInstallerName();

  public long getFacilityID();

  public long getSolarSystemID();

  public String getSolarSystemName();

  public long getStationID();

  public long getActivityID();

  public long getBlueprintID();

  public long getBlueprintTypeID();

  public String getBlueprintTypeName();

  public long getBlueprintLocationID();

  public long getOutputLocationID();

  public int getRuns();

  public BigDecimal getCost();

  public long getTeamID();

  public int getLicensedRuns();

  public double getProbability();

  public long getProductTypeID();

  public String getProductTypeName();

  public int getStatus();

  public long getTimeInSeconds();

  public Date getStartDate();

  public Date getEndDate();

  public Date getPauseDate();

  public Date getCompletedDate();

  public long getCompletedCharacterID();

  public int getSuccessfulRuns();
}
