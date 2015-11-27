package enterprises.orbital.evexmlapi.eve;

import java.util.Collection;

public interface ISkillGroup {
	public int getGroupID();

	public String getGroupName();

	public Collection<ISkillMember> getSkills();
}
