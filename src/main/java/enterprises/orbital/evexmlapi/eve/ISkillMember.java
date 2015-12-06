package enterprises.orbital.evexmlapi.eve;

import java.util.Collection;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = ISkillMember.class)
public interface ISkillMember {
  public String getDescription();

  public int getGroupID();

  public int getRank();

  public Collection<IRequiredSkill> getRequiredSkills();

  public Collection<IBonus> getBonuses();

  public String getRequiredPrimaryAttribute();

  public String getRequiredSecondaryAttribute();

  public int getTypeID();

  public String getTypeName();

  public boolean isPublished();
}
