package enterprises.orbital.evexmlapi.crp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = ICombatSetting.class)
public interface ICombatSetting {
  public int getStanding();

  public boolean isEnabled();
}
