package enterprises.orbital.evexmlapi.chr;

import java.util.Set;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(
    as = ISkillInfo.class)
public interface ISkillInfo {
  public int getFreeSkillPoints();

  public Set<ISkill> getSkills();

}
