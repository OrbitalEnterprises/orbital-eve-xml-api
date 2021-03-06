package enterprises.orbital.evexmlapi.chr;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = ISkillInQueue.class)
public interface ISkillInQueue {
  public int getEndSP();

  public Date getEndTime();

  public int getLevel();

  public int getQueuePosition();

  public int getStartSP();

  public Date getStartTime();

  public int getTypeID();
}
