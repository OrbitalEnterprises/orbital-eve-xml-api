package enterprises.orbital.impl.evexmlapi.eve;

import java.util.ArrayList;
import java.util.Collection;

import enterprises.orbital.evexmlapi.eve.ISkillGroup;
import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class SkillTreeResponse extends ApiResponse {
  private final Collection<ISkillGroup> skillGroups = new ArrayList<ISkillGroup>();

  public void addSkillGroup(ApiSkillGroup skillGroup) {
    skillGroups.add(skillGroup);
  }

  public Collection<ISkillGroup> getSkillGroups() {
    return skillGroups;
  }
}
