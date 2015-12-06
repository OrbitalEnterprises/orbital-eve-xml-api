package enterprises.orbital.evexmlapi.eve;

import java.util.Collection;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = ISkillGroup.class)
public interface ISkillGroup {
  public int getGroupID();

  public String getGroupName();

  public Collection<ISkillMember> getSkills();
}
