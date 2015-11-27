package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.evexmlapi.chr.ISkill;

public class ApiCharacterSkill implements ISkill {
  private int     typeID      = 0;
  private int     level       = 0;
  private int     skillpoints = 0;
  private boolean published   = false;

  public int getTypeID() {
    return typeID;
  }

  public void setTypeID(int typeID) {
    this.typeID = typeID;
  }

  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  public int getSkillpoints() {
    return skillpoints;
  }

  public void setSkillpoints(int skillpoints) {
    this.skillpoints = skillpoints;
  }

  public boolean isPublished() {
    return published;
  }

  public void setPublished(boolean published) {
    this.published = published;
  }
}
