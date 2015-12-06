package enterprises.orbital.evexmlapi.eve;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IBonus.class)
public interface IBonus {
  public String getBonusType();

  public String getBonusValue();
}
