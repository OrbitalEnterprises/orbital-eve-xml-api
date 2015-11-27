package enterprises.orbital.impl.evexmlapi.eve;

import enterprises.orbital.evexmlapi.eve.IBonus;

public class ApiBonus implements Detail, IBonus {
  private String bonusType;
  private String bonusValue;

  @Override
  public String getBonusType() {
    return bonusType;
  }

  public void setBonusType(String bonusType) {
    this.bonusType = bonusType;
  }

  @Override
  public String getBonusValue() {
    return bonusValue;
  }

  public void setBonusValue(String bonusValue) {
    this.bonusValue = bonusValue;
  }

  @Override
  public String toString() {
    return bonusType + " " + bonusValue + "\n";
  }
}
