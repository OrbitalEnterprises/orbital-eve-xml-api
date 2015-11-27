package enterprises.orbital.impl.evexmlapi.chr;

import java.util.Date;

import enterprises.orbital.evexmlapi.chr.ISkillInTraining;
import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class SkillInTrainingResponse extends ApiResponse implements ISkillInTraining {
  private static final long serialVersionUID = 2174003334726975611L;
  private Date              currentTQTime;
  private Date              trainingEndTime;
  private Date              trainingStartTime;
  private int               trainingTypeID;
  private int               trainingStartSP;
  private int               trainingDestinationSP;
  private int               trainingToLevel;
  private boolean           skillInTraining;

  @Override
  public Date getCurrentTrainingQueueTime() {
    return currentTQTime;
  }

  public void setCurrentTQTime(Date currentTQTime) {
    this.currentTQTime = currentTQTime;
  }

  @Override
  public Date getTrainingEndTime() {
    return trainingEndTime;
  }

  public void setTrainingEndTime(Date trainingEndTime) {
    this.trainingEndTime = trainingEndTime;
  }

  @Override
  public Date getTrainingStartTime() {
    return trainingStartTime;
  }

  public void setTrainingStartTime(Date trainingStartTime) {
    this.trainingStartTime = trainingStartTime;
  }

  @Override
  public int getSkillTypeID() {
    return trainingTypeID;
  }

  public void setTrainingTypeID(int trainingTypeID) {
    this.trainingTypeID = trainingTypeID;
  }

  @Override
  public int getTrainingStartSP() {
    return trainingStartSP;
  }

  public void setTrainingStartSP(int trainingStartSP) {
    this.trainingStartSP = trainingStartSP;
  }

  @Override
  public int getTrainingDestinationSP() {
    return trainingDestinationSP;
  }

  public void setTrainingDestinationSP(int trainingDestinationSP) {
    this.trainingDestinationSP = trainingDestinationSP;
  }

  @Override
  public int getTrainingToLevel() {
    return trainingToLevel;
  }

  public void setTrainingToLevel(int trainingToLevel) {
    this.trainingToLevel = trainingToLevel;
  }

  @Override
  public boolean isSkillInTraining() {
    return skillInTraining;
  }

  public void setSkillInTraining(boolean skillInTraining) {
    this.skillInTraining = skillInTraining;
  }

}
