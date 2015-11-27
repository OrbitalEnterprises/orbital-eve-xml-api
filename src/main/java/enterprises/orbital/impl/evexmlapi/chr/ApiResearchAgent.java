package enterprises.orbital.impl.evexmlapi.chr;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import enterprises.orbital.evexmlapi.chr.IResearchAgent;

public class ApiResearchAgent implements IResearchAgent {
  private int    agentID;
  private int    skillTypeID;
  private Date   researchStartDate;
  private double pointsPerDay;
  private double remainderPoints;

  @Override
  public int getAgentID() {
    return agentID;
  }

  public void setAgentID(int agentID) {
    this.agentID = agentID;
  }

  @Override
  public int getSkillTypeID() {
    return skillTypeID;
  }

  public void setSkillTypeID(int skillTypeID) {
    this.skillTypeID = skillTypeID;
  }

  @Override
  public Date getResearchStartDate() {
    return researchStartDate;
  }

  public void setResearchStartDate(Date researchStartDate) {
    this.researchStartDate = researchStartDate;
  }

  @Override
  public double getPointsPerDay() {
    return pointsPerDay;
  }

  public void setPointsPerDay(double pointsPerDay) {
    this.pointsPerDay = pointsPerDay;
  }

  @Override
  public double getRemainderPoints() {
    return remainderPoints;
  }

  public void setRemainderPoints(double remainderPoints) {
    this.remainderPoints = remainderPoints;
  }

  @Override
  public double getCurrentPoints() {
    long startDate = researchStartDate.getTime();
    long now = Calendar.getInstance(TimeZone.getTimeZone("GMT")).getTimeInMillis();
    long elapse = now - startDate;
    double daysSinceStart = elapse / (1000.0 * 60 * 60 * 24);
    return remainderPoints + (pointsPerDay * daysSinceStart);
  }
}