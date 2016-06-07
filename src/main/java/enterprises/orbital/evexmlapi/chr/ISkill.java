package enterprises.orbital.evexmlapi.chr;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = ISkill.class)
public interface ISkill {
  public int getLevel();

  public int getSkillpoints();

  public int getTypeID();

  public boolean isPublished();
}
