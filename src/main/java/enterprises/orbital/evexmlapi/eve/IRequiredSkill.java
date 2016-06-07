package enterprises.orbital.evexmlapi.eve;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IRequiredSkill.class)
public interface IRequiredSkill {
  public int getLevel();

  public int getTypeID();

}
