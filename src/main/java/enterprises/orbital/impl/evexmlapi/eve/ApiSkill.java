package enterprises.orbital.impl.evexmlapi.eve;

import java.util.Collection;
import java.util.HashSet;

import enterprises.orbital.evexmlapi.eve.IBonus;
import enterprises.orbital.evexmlapi.eve.IRequiredSkill;
import enterprises.orbital.evexmlapi.eve.ISkillMember;

public class ApiSkill implements Comparable<ApiSkill>, ISkillMember {
  private int                        typeID;
  private int                        groupID;
  private String                     typeName;
  private String                     description;
  private int                        rank;
  private boolean                    published;
  private Collection<IRequiredSkill> requiredSkills = new HashSet<IRequiredSkill>();
  private final Collection<IBonus>   bonuses        = new HashSet<IBonus>();
  private String                     primaryAttribute;
  private String                     secondaryAttribute;

  @Override
  public Collection<IBonus> getBonuses() {
    return bonuses;
  }

  @Override
  public String getRequiredPrimaryAttribute() {
    return primaryAttribute;
  }

  public void setPrimaryAttribute(String primaryAttribute) {
    this.primaryAttribute = primaryAttribute;
  }

  @Override
  public String getRequiredSecondaryAttribute() {
    return secondaryAttribute;
  }

  public void setSecondaryAttribute(String secondaryAttribute) {
    this.secondaryAttribute = secondaryAttribute;
  }

  @Override
  public int getTypeID() {
    return typeID;
  }

  public void setTypeID(int typeID) {
    this.typeID = typeID;
  }

  @Override
  public int getGroupID() {
    return groupID;
  }

  public void setGroupID(int groupID) {
    this.groupID = groupID;
  }

  @Override
  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  @Override
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public int getRank() {
    return rank;
  }

  public void setRank(int rank) {
    this.rank = rank;
  }

  @Override
  public boolean isPublished() {
    return published;
  }

  public void setPublished(boolean published) {
    this.published = published;
  }

  @Override
  public Collection<IRequiredSkill> getRequiredSkills() {
    return requiredSkills;
  }

  public void setRequiredSkills(Collection<ApiRequirement> requiredSkills) {
    this.requiredSkills.addAll(requiredSkills);
  }

  public void addSkillDetail(Detail skillDetail) {
    if (skillDetail instanceof ApiRequirement) {
      requiredSkills.add((ApiRequirement) skillDetail);
    } else if (skillDetail instanceof ApiBonus) {
      bonuses.add((ApiBonus) skillDetail);
    }
  }

  @Override
  public int compareTo(ApiSkill o) {
    return typeName.compareTo(o.typeName);
  }

}
