package enterprises.orbital.impl.evexmlapi.chr;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import enterprises.orbital.evexmlapi.chr.ICharacterRole;
import enterprises.orbital.evexmlapi.chr.ICharacterSheet;
import enterprises.orbital.evexmlapi.chr.ICharacterTitle;
import enterprises.orbital.evexmlapi.chr.ISkill;

public class CharacterSheetResponse extends PartialCharacterSheetResponse implements ICharacterSheet {
  private long                          characterID;
  private String                        name;
  private String                        corporationName;
  private long                          corporationID;
  private BigDecimal                    balance;
  private long                          homeStationID;
  private String                        allianceName;
  private long                          allianceID;
  private String                        factionName;
  private long                          factionID;
  private int                           cloneTypeID;
  private String                        cloneName;
  private int                           cloneSkillPoints;
  private int                           freeSkillPoints;
  private final Set<ApiCharacterSkill>  skills = new HashSet<ApiCharacterSkill>();
  private final List<ApiCharacterRole>  roles  = new ArrayList<ApiCharacterRole>();
  private final List<ApiCharacterTitle> titles = new ArrayList<ApiCharacterTitle>();

  @Override
  public long getCharacterID() {
    return characterID;
  }

  public void setCharacterID(
                             long characterID) {
    this.characterID = characterID;
  }

  @Override
  public String getName() {
    return name;
  }

  public void setName(
                      String name) {
    this.name = name;
  }

  @Override
  public String getCorporationName() {
    return corporationName;
  }

  public void setCorporationName(
                                 String corporationName) {
    this.corporationName = corporationName;
  }

  @Override
  public long getCorporationID() {
    return corporationID;
  }

  public void setCorporationID(
                               long corporationID) {
    this.corporationID = corporationID;
  }

  @Override
  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(
                         BigDecimal balance) {
    this.balance = balance.setScale(2, RoundingMode.HALF_UP);
  }

  public void setHomeStationID(
                               long homeStationID) {
    this.homeStationID = homeStationID;
  }

  public void setAllianceName(
                              String allianceName) {
    if (allianceName.length() == 0)
      this.allianceName = null;
    else
      this.allianceName = allianceName;
  }

  public void setAllianceID(
                            long allianceID) {
    this.allianceID = allianceID;
  }

  public void setFactionName(
                             String factionName) {
    if (factionName.length() == 0)
      this.factionName = null;
    else
      this.factionName = factionName;
  }

  public void setFactionID(
                           long factionID) {
    this.factionID = factionID;
  }

  public void setCloneTypeID(
                             int cloneTypeID) {
    this.cloneTypeID = cloneTypeID;
  }

  public void setFreeSkillPoints(
                                 int freeSkillPoints) {
    this.freeSkillPoints = freeSkillPoints;
  }

  @Override
  public long getHomeStationID() {
    return homeStationID;
  }

  @Override
  public String getFactionName() {
    return factionName;
  }

  @Override
  public long getFactionID() {
    return factionID;
  }

  @Override
  public int getCloneTypeID() {
    return cloneTypeID;
  }

  @Override
  public int getFreeSkillPoints() {
    return freeSkillPoints;
  }

  @Override
  public String getAllianceName() {
    return allianceName;
  }

  @Override
  public long getAllianceID() {
    return allianceID;
  }

  public void setCloneName(
                           String cloneName) {
    this.cloneName = cloneName;
  }

  public void setCloneSkillPoints(
                                  int cloneSkillPoints) {
    this.cloneSkillPoints = cloneSkillPoints;
  }

  @Override
  public String getCloneName() {
    return cloneName;
  }

  @Override
  public int getCloneSkillPoints() {
    return cloneSkillPoints;
  }

  @Override
  public void addCollector(
                           CharacterSheetRowsetDataCollector c) {
    // Copy collector objects based on type
    if (c.type.equals("skills")) {
      for (CharacterSheetRowsetData next : c.stuff) {
        ApiCharacterSkill newSkill = new ApiCharacterSkill();
        newSkill.setTypeID(next.getTypeID());
        newSkill.setLevel(next.getLevel());
        newSkill.setSkillpoints(next.getSkillpoints());
        newSkill.setPublished(next.isPublished());
        skills.add(newSkill);
      }
    } else if (c.type.equals("corporationRoles") || c.type.equals("corporationRolesAtHQ") || c.type.equals("corporationRolesAtBase")
        || c.type.equals("corporationRolesAtOther")) {
      for (CharacterSheetRowsetData next : c.stuff) {
        ApiCharacterRole newRole = new ApiCharacterRole();
        newRole.setRoleCategory(c.type);
        newRole.setRoleID(next.getRoleID());
        newRole.setRoleName(next.getRoleName());
        roles.add(newRole);
      }
    } else if (c.type.equals("corporationTitles")) {
      for (CharacterSheetRowsetData next : c.stuff) {
        ApiCharacterTitle newTitle = new ApiCharacterTitle();
        newTitle.setTitleID(next.getTitleID());
        newTitle.setTitleName(next.getTitleName());
        titles.add(newTitle);
      }
    } else
      super.addCollector(c);
  }

  @Override
  public Set<ISkill> getSkills() {
    Set<ISkill> result = new HashSet<ISkill>();
    result.addAll(skills);
    return result;
  }

  @Override
  public Collection<ICharacterRole> getRoles() {
    Collection<ICharacterRole> result = new ArrayList<ICharacterRole>();
    result.addAll(roles);
    return result;
  }

  @Override
  public Collection<ICharacterTitle> getTitles() {
    Collection<ICharacterTitle> result = new ArrayList<ICharacterTitle>();
    result.addAll(titles);
    return result;
  }

}
