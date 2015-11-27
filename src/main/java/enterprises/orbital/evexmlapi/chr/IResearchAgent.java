package enterprises.orbital.evexmlapi.chr;

import java.util.Date;

public interface IResearchAgent {
  public int getAgentID();

  public double getCurrentPoints();

  public double getPointsPerDay();

  public double getRemainderPoints();

  public Date getResearchStartDate();

  public int getSkillTypeID();
}
