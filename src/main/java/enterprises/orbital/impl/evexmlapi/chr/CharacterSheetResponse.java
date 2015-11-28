package enterprises.orbital.impl.evexmlapi.chr;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Logger;

import enterprises.orbital.evexmlapi.chr.ICharacterRole;
import enterprises.orbital.evexmlapi.chr.ICharacterSheet;
import enterprises.orbital.evexmlapi.chr.ICharacterTitle;
import enterprises.orbital.evexmlapi.chr.IImplant;
import enterprises.orbital.evexmlapi.chr.IJumpClone;
import enterprises.orbital.evexmlapi.chr.IJumpCloneImplant;
import enterprises.orbital.evexmlapi.chr.ISkill;
import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class CharacterSheetResponse extends ApiResponse implements ICharacterSheet {
  private static final Logger           log               = Logger.getLogger(CharacterSheetResponse.class.getName());

  private long                          characterID;
  private String                        name;
  private String                        race;
  private Date                          dateOfBirth;
  private String                        bloodLine;
  private String                        ancestry;
  private String                        gender;
  private String                        corporationName;
  private long                          corporationID;
  private BigDecimal                    balance;
  private int                           intelligence;
  private int                           memory;
  private int                           charisma;
  private int                           perception;
  private int                           willpower;
  private long                          homeStationID;
  private String                        allianceName;
  private long                          allianceID;
  private String                        factionName;
  private long                          factionID;
  private int                           cloneTypeID;
  private String                        cloneName;
  private int                           cloneSkillPoints;
  private int                           freeSkillPoints;
  private int                           freeRespecs;
  private Date                          cloneJumpDate;
  private Date                          lastRespecDate;
  private Date                          lastTimedRespec;
  private Date                          remoteStationDate;
  private Date                          jumpActivation;
  private Date                          jumpFatigue;
  private Date                          jumpLastUpdate;
  private final Set<ApiCharacterSkill>  skills            = new HashSet<ApiCharacterSkill>();
  private final List<ApiCharacterRole>  roles             = new ArrayList<ApiCharacterRole>();
  private final List<ApiCharacterTitle> titles            = new ArrayList<ApiCharacterTitle>();
  private final List<JumpClone>         jumpClones        = new ArrayList<JumpClone>();
  private final List<JumpCloneImplant>  jumpCloneImplants = new ArrayList<JumpCloneImplant>();
  private final List<Implant>           implants          = new ArrayList<Implant>();

  @Override
  public long getCharacterID() {
    return characterID;
  }

  public void setCharacterID(long characterID) {
    this.characterID = characterID;
  }

  @Override
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getRace() {
    return race;
  }

  public void setRace(String race) {
    this.race = race;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date doB) {
    dateOfBirth = doB;
  }

  public String getBloodLine() {
    return bloodLine;
  }

  public void setBloodLine(String bloodLine) {
    this.bloodLine = bloodLine;
  }

  @Override
  public String getAncestry() {
    return ancestry;
  }

  public void setAncestry(String ancestry) {
    this.ancestry = ancestry;
  }

  @Override
  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }

  @Override
  public String getCorporationName() {
    return corporationName;
  }

  public void setCorporationName(String corporationName) {
    this.corporationName = corporationName;
  }

  @Override
  public long getCorporationID() {
    return corporationID;
  }

  public void setCorporationID(long corporationID) {
    this.corporationID = corporationID;
  }

  @Override
  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance.setScale(2, RoundingMode.HALF_UP);
  }

  @Override
  public int getIntelligence() {
    return intelligence;
  }

  public void setIntelligence(int intelligence) {
    this.intelligence = intelligence;
  }

  @Override
  public int getMemory() {
    return memory;
  }

  public void setMemory(int memory) {
    this.memory = memory;
  }

  @Override
  public int getCharisma() {
    return charisma;
  }

  public void setCharisma(int charisma) {
    this.charisma = charisma;
  }

  @Override
  public int getPerception() {
    return perception;
  }

  public void setPerception(int perception) {
    this.perception = perception;
  }

  @Override
  public int getWillpower() {
    return willpower;
  }

  public void setWillpower(int willpower) {
    this.willpower = willpower;
  }

  public void setHomeStationID(long homeStationID) {
    this.homeStationID = homeStationID;
  }

  public void setAllianceName(String allianceName) {
    if (allianceName.length() == 0)
      this.allianceName = null;
    else
      this.allianceName = allianceName;
  }

  public void setAllianceID(long allianceID) {
    this.allianceID = allianceID;
  }

  public void setFactionName(String factionName) {
    if (factionName.length() == 0)
      this.factionName = null;
    else
      this.factionName = factionName;
  }

  public void setFactionID(long factionID) {
    this.factionID = factionID;
  }

  public void setCloneTypeID(int cloneTypeID) {
    this.cloneTypeID = cloneTypeID;
  }

  public void setFreeSkillPoints(int freeSkillPoints) {
    this.freeSkillPoints = freeSkillPoints;
  }

  public void setFreeRespecs(int freeRespecs) {
    this.freeRespecs = freeRespecs;
  }

  public void setCloneJumpDate(Date cloneJumpDate) {
    this.cloneJumpDate = cloneJumpDate;
  }

  public void setLastRespecDate(Date lastRespecDate) {
    this.lastRespecDate = lastRespecDate;
  }

  public void setLastTimedRespec(Date lastTimedRespec) {
    this.lastTimedRespec = lastTimedRespec;
  }

  public void setRemoteStationDate(Date remoteStationDate) {
    this.remoteStationDate = remoteStationDate;
  }

  public void setJumpActivation(Date jumpActivation) {
    this.jumpActivation = jumpActivation;
  }

  public void setJumpFatigue(Date jumpFatigue) {
    this.jumpFatigue = jumpFatigue;
  }

  public void setJumpLastUpdate(Date jumpLastUpdate) {
    this.jumpLastUpdate = jumpLastUpdate;
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
  public int getFreeRespecs() {
    return freeRespecs;
  }

  @Override
  public Date getCloneJumpDate() {
    return cloneJumpDate;
  }

  @Override
  public Date getLastRespecDate() {
    return lastRespecDate;
  }

  @Override
  public Date getLastTimedRespec() {
    return lastTimedRespec;
  }

  @Override
  public Date getRemoteStationDate() {
    return remoteStationDate;
  }

  @Override
  public Date getJumpActivation() {
    return jumpActivation;
  }

  @Override
  public Date getJumpFatigue() {
    return jumpFatigue;
  }

  @Override
  public Date getJumpLastUpdate() {
    return jumpLastUpdate;
  }

  @Override
  public String getAllianceName() {
    return allianceName;
  }

  @Override
  public long getAllianceID() {
    return allianceID;
  }

  public void setCloneName(String cloneName) {
    this.cloneName = cloneName;
  }

  public void setCloneSkillPoints(int cloneSkillPoints) {
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

  public void addCollector(CharacterSheetRowsetDataCollector c) {
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
    } else if (c.type.equals("jumpClones")) {
      for (CharacterSheetRowsetData next : c.stuff) {
        JumpClone newClone = new JumpClone();
        newClone.setJumpCloneID(next.getJumpCloneID());
        newClone.setTypeID(next.getTypeID());
        newClone.setLocationID(next.getLocationID());
        newClone.setCloneName(next.getCloneName());
        jumpClones.add(newClone);
      }
    } else if (c.type.equals("jumpCloneImplants")) {
      for (CharacterSheetRowsetData next : c.stuff) {
        JumpCloneImplant newCloneImplant = new JumpCloneImplant();
        newCloneImplant.setJumpCloneID(next.getJumpCloneID());
        newCloneImplant.setTypeID(next.getTypeID());
        newCloneImplant.setTypeName(next.getTypeName());
        jumpCloneImplants.add(newCloneImplant);
      }
    } else if (c.type.equals("implants")) {
      for (CharacterSheetRowsetData next : c.stuff) {
        Implant newImplant = new Implant();
        newImplant.setTypeID(next.getTypeID());
        newImplant.setTypeName(next.getTypeName());
        implants.add(newImplant);
      }
    } else
      log.warning("Ignoring unknown collection type: " + c.type);
  }

  @Override
  public List<IJumpClone> getJumpClones() {
    List<IJumpClone> result = new ArrayList<IJumpClone>();
    result.addAll(jumpClones);
    return result;
  }

  @Override
  public List<IJumpCloneImplant> getJumpCloneImplants() {
    List<IJumpCloneImplant> result = new ArrayList<IJumpCloneImplant>();
    result.addAll(jumpCloneImplants);
    return result;
  }

  @Override
  public List<IImplant> getImplants() {
    List<IImplant> result = new ArrayList<IImplant>();
    result.addAll(implants);
    return result;
  }

  @Override
  public String getBloodline() {
    return bloodLine;
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

  @Override
  public Date getDoB() {
    return dateOfBirth;
  }

}
