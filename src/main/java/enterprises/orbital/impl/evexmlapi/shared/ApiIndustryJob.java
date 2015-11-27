package enterprises.orbital.impl.evexmlapi.shared;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import enterprises.orbital.evexmlapi.shared.IIndustryJob;

public class ApiIndustryJob implements IIndustryJob {
  private long       jobID;
  private long       installerID;
  private String     installerName;
  private long       facilityID;
  private long       solarSystemID;
  private String     solarSystemName;
  private long       stationID;
  private long       activityID;
  private long       blueprintID;
  private long       blueprintTypeID;
  private String     blueprintTypeName;
  private long       blueprintLocationID;
  private long       outputLocationID;
  private int        runs;
  private BigDecimal cost;
  private long       teamID;
  private int        licensedRuns;
  private double     probability;
  private long       productTypeID;
  private String     productTypeName;
  private int        status;
  private long       timeInSeconds;
  private Date       startDate;
  private Date       endDate;
  private Date       pauseDate;
  private Date       completedDate;
  private long       completedCharacterID;
  private int        successfulRuns;

  @Override
  public long getJobID() {
    return jobID;
  }

  public void setJobID(long jobID) {
    this.jobID = jobID;
  }

  @Override
  public long getInstallerID() {
    return installerID;
  }

  public void setInstallerID(long installerID) {
    this.installerID = installerID;
  }

  @Override
  public String getInstallerName() {
    return installerName;
  }

  public void setInstallerName(String installerName) {
    this.installerName = installerName;
  }

  @Override
  public long getFacilityID() {
    return facilityID;
  }

  public void setFacilityID(long facilityID) {
    this.facilityID = facilityID;
  }

  @Override
  public long getSolarSystemID() {
    return solarSystemID;
  }

  public void setSolarSystemID(long solarSystemID) {
    this.solarSystemID = solarSystemID;
  }

  @Override
  public String getSolarSystemName() {
    return solarSystemName;
  }

  public void setSolarSystemName(String solarSystemName) {
    this.solarSystemName = solarSystemName;
  }

  @Override
  public long getStationID() {
    return stationID;
  }

  public void setStationID(long stationID) {
    this.stationID = stationID;
  }

  @Override
  public long getActivityID() {
    return activityID;
  }

  public void setActivityID(long activityID) {
    this.activityID = activityID;
  }

  @Override
  public long getBlueprintID() {
    return blueprintID;
  }

  public void setBlueprintID(long blueprintID) {
    this.blueprintID = blueprintID;
  }

  @Override
  public long getBlueprintTypeID() {
    return blueprintTypeID;
  }

  public void setBlueprintTypeID(long blueprintTypeID) {
    this.blueprintTypeID = blueprintTypeID;
  }

  @Override
  public String getBlueprintTypeName() {
    return blueprintTypeName;
  }

  public void setBlueprintTypeName(String blueprintTypeName) {
    this.blueprintTypeName = blueprintTypeName;
  }

  @Override
  public long getBlueprintLocationID() {
    return blueprintLocationID;
  }

  public void setBlueprintLocationID(long blueprintLocationID) {
    this.blueprintLocationID = blueprintLocationID;
  }

  @Override
  public long getOutputLocationID() {
    return outputLocationID;
  }

  public void setOutputLocationID(long outputLocationID) {
    this.outputLocationID = outputLocationID;
  }

  @Override
  public int getRuns() {
    return runs;
  }

  public void setRuns(int runs) {
    this.runs = runs;
  }

  @Override
  public BigDecimal getCost() {
    return cost;
  }

  public void setCost(BigDecimal cost) {
    this.cost = cost.setScale(2, RoundingMode.HALF_UP);
  }

  @Override
  public long getTeamID() {
    return teamID;
  }

  public void setTeamID(long teamID) {
    this.teamID = teamID;
  }

  @Override
  public int getLicensedRuns() {
    return licensedRuns;
  }

  public void setLicensedRuns(int licensedRuns) {
    this.licensedRuns = licensedRuns;
  }

  @Override
  public double getProbability() {
    return probability;
  }

  public void setProbability(double probability) {
    this.probability = probability;
  }

  @Override
  public long getProductTypeID() {
    return productTypeID;
  }

  public void setProductTypeID(long productTypeID) {
    this.productTypeID = productTypeID;
  }

  @Override
  public String getProductTypeName() {
    return productTypeName;
  }

  public void setProductTypeName(String productTypeName) {
    this.productTypeName = productTypeName;
  }

  @Override
  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
  }

  @Override
  public long getTimeInSeconds() {
    return timeInSeconds;
  }

  public void setTimeInSeconds(long timeInSeconds) {
    this.timeInSeconds = timeInSeconds;
  }

  @Override
  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  @Override
  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  @Override
  public Date getPauseDate() {
    return pauseDate;
  }

  public void setPauseDate(Date pauseDate) {
    this.pauseDate = pauseDate;
  }

  @Override
  public Date getCompletedDate() {
    return completedDate;
  }

  public void setCompletedDate(Date completedDate) {
    this.completedDate = completedDate;
  }

  @Override
  public long getCompletedCharacterID() {
    return completedCharacterID;
  }

  public void setCompletedCharacterID(long completedCharacterID) {
    this.completedCharacterID = completedCharacterID;
  }

  @Override
  public int getSuccessfulRuns() {
    return successfulRuns;
  }

  public void setSuccessfulRuns(int successfulRuns) {
    this.successfulRuns = successfulRuns;
  }

}
