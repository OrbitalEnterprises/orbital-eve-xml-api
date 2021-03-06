package enterprises.orbital.evexmlapi.chr;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = ISkillInTraining.class)
public interface ISkillInTraining {
  public boolean isSkillInTraining();

  public Date getCurrentTrainingQueueTime();

  public Date getTrainingStartTime();

  public Date getTrainingEndTime();

  public int getTrainingStartSP();

  public int getTrainingDestinationSP();

  public int getTrainingToLevel();

  public int getSkillTypeID();
}
