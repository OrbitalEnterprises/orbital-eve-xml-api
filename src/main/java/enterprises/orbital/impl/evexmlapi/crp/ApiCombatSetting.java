package enterprises.orbital.impl.evexmlapi.crp;

import enterprises.orbital.evexmlapi.crp.ICombatSetting;

public class ApiCombatSetting implements ICombatSetting {
  private boolean enabled;
  private int     standing;

  @Override
  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  @Override
  public int getStanding() {
    return standing;
  }

  public void setStanding(int standing) {
    this.standing = standing;
  }
}
