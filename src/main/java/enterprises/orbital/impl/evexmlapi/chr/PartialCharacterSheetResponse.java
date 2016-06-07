package enterprises.orbital.impl.evexmlapi.chr;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

import enterprises.orbital.evexmlapi.chr.IImplant;
import enterprises.orbital.evexmlapi.chr.IJumpClone;
import enterprises.orbital.evexmlapi.chr.IJumpCloneImplant;
import enterprises.orbital.evexmlapi.chr.IPartialCharacterSheet;
import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class PartialCharacterSheetResponse extends ApiResponse implements IPartialCharacterSheet {
  private static final Logger          log               = Logger.getLogger(PartialCharacterSheetResponse.class.getName());

  private Date                         dateOfBirth;
  private String                       race;
  private int                          bloodLineID;
  private String                       bloodLine;
  private int                          ancestryID;
  private String                       ancestry;
  private String                       gender;
  private int                          freeRespecs;
  private Date                         cloneJumpDate;
  private Date                         lastRespecDate;
  private Date                         lastTimedRespec;
  private Date                         remoteStationDate;
  private int                          intelligence;
  private int                          memory;
  private int                          charisma;
  private int                          perception;
  private int                          willpower;
  private Date                         jumpActivation;
  private Date                         jumpFatigue;
  private Date                         jumpLastUpdate;
  private final List<Implant>          implants          = new ArrayList<Implant>();
  private final List<JumpClone>        jumpClones        = new ArrayList<JumpClone>();
  private final List<JumpCloneImplant> jumpCloneImplants = new ArrayList<JumpCloneImplant>();

  @Override
  public String getRace() {
    return race;
  }

  public void setRace(
                      String race) {
    this.race = race;
  }

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(
                             Date doB) {
    dateOfBirth = doB;
  }

  public int getBloodLineID() {
    return bloodLineID;
  }

  public void setBloodLineID(
                             int bloodLineID) {
    this.bloodLineID = bloodLineID;
  }

  public String getBloodLine() {
    return bloodLine;
  }

  public void setBloodLine(
                           String bloodLine) {
    this.bloodLine = bloodLine;
  }

  @Override
  public int getAncestryID() {
    return ancestryID;
  }

  public void setAncestryID(
                            int ancestryID) {
    this.ancestryID = ancestryID;
  }

  @Override
  public String getAncestry() {
    return ancestry;
  }

  public void setAncestry(
                          String ancestry) {
    this.ancestry = ancestry;
  }

  @Override
  public String getGender() {
    return gender;
  }

  public void setGender(
                        String gender) {
    this.gender = gender;
  }

  @Override
  public int getIntelligence() {
    return intelligence;
  }

  public void setIntelligence(
                              int intelligence) {
    this.intelligence = intelligence;
  }

  @Override
  public int getMemory() {
    return memory;
  }

  public void setMemory(
                        int memory) {
    this.memory = memory;
  }

  @Override
  public int getCharisma() {
    return charisma;
  }

  public void setCharisma(
                          int charisma) {
    this.charisma = charisma;
  }

  @Override
  public int getPerception() {
    return perception;
  }

  public void setPerception(
                            int perception) {
    this.perception = perception;
  }

  @Override
  public int getWillpower() {
    return willpower;
  }

  public void setWillpower(
                           int willpower) {
    this.willpower = willpower;
  }

  public void setFreeRespecs(
                             int freeRespecs) {
    this.freeRespecs = freeRespecs;
  }

  public void setCloneJumpDate(
                               Date cloneJumpDate) {
    this.cloneJumpDate = cloneJumpDate;
  }

  public void setLastRespecDate(
                                Date lastRespecDate) {
    this.lastRespecDate = lastRespecDate;
  }

  public void setLastTimedRespec(
                                 Date lastTimedRespec) {
    this.lastTimedRespec = lastTimedRespec;
  }

  public void setRemoteStationDate(
                                   Date remoteStationDate) {
    this.remoteStationDate = remoteStationDate;
  }

  public void setJumpActivation(
                                Date jumpActivation) {
    this.jumpActivation = jumpActivation;
  }

  public void setJumpFatigue(
                             Date jumpFatigue) {
    this.jumpFatigue = jumpFatigue;
  }

  public void setJumpLastUpdate(
                                Date jumpLastUpdate) {
    this.jumpLastUpdate = jumpLastUpdate;
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

  public void addCollector(
                           CharacterSheetRowsetDataCollector c) {
    // Copy collector objects based on type
    if (c.type.equals("jumpClones")) {
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
  public int getBloodlineID() {
    return bloodLineID;
  }

  @Override
  public Date getDoB() {
    return dateOfBirth;
  }

}
