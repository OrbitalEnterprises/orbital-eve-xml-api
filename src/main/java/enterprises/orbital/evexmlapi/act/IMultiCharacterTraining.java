package enterprises.orbital.evexmlapi.act;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IMultiCharacterTraining.class)
public interface IMultiCharacterTraining {
  public Date getTrainingEnd();
}
