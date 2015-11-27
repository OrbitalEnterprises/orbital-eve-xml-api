package enterprises.orbital.impl.evexmlapi.eve;

import enterprises.orbital.evexmlapi.eve.IRequiredSkill;

public class ApiRequirement implements Detail, IRequiredSkill {
  private int typeID;
  private int skillLevel;

  @Override
  public int getTypeID() {
    return typeID;
  }

  public void setTypeID(int typeID) {
    this.typeID = typeID;
  }

  @Override
  public int getLevel() {
    return skillLevel;
  }

  public void setSkillLevel(int skillLevel) {
    this.skillLevel = skillLevel;
  }

  @Override
  public String toString() {
    return "Type: " + typeID + " at level: " + skillLevel;
  }

}
