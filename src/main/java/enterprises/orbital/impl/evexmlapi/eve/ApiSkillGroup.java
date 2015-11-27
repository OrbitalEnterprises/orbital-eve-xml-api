package enterprises.orbital.impl.evexmlapi.eve;

import java.util.ArrayList;
import java.util.Collection;

import enterprises.orbital.evexmlapi.eve.ISkillGroup;
import enterprises.orbital.evexmlapi.eve.ISkillMember;

public class ApiSkillGroup implements Comparable<ApiSkillGroup>, ISkillGroup {
  private String                         groupName;
  private int                            groupID;
  private final Collection<ISkillMember> skills = new ArrayList<ISkillMember>();

  @Override
  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  @Override
  public int getGroupID() {
    return groupID;
  }

  public void setGroupID(int groupID) {
    this.groupID = groupID;
  }

  public void addSkill(ApiSkill skill) {
    skills.add(skill);
  }

  @Override
  public Collection<ISkillMember> getSkills() {
    return skills;
  }

  @Override
  public int compareTo(ApiSkillGroup o) {
    return groupName.compareTo(o.groupName);
  }
}
