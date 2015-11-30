package enterprises.orbital.impl.evexmlapi.act;

import java.util.Date;

import enterprises.orbital.evexmlapi.act.IMultiCharacterTraining;

public class ApiMultiCharacterTraining implements IMultiCharacterTraining {
  private Date trainingEnd;

  @Override
  public Date getTrainingEnd() {
    return trainingEnd;
  }

  public void setTrainingEnd(Date trainingEnd) {
    this.trainingEnd = trainingEnd;
  }

}