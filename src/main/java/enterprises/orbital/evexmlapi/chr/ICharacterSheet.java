package enterprises.orbital.evexmlapi.chr;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface ICharacterSheet {
  public BigDecimal getBalance();

  public String getBloodline();

  public long getCharacterID();

  public int getCharisma();

  public long getCorporationID();

  public String getCorporationName();

  public String getGender();

  public int getIntelligence();

  public int getMemory();

  public String getName();

  public int getPerception();

  public String getRace();

  public Set<ISkill> getSkills();

  public int getWillpower();

  public Date getDoB();

  public String getAncestry();

  public String getCloneName();

  public int getCloneSkillPoints();

  public String getAllianceName();

  public long getAllianceID();

  public String getFactionName();

  public long getFactionID();

  public Collection<ICharacterRole> getRoles();

  public Collection<ICharacterTitle> getTitles();

  // Added in Phoebe
  public long getHomeStationID();

  // Added in Phoebe
  public Date getCloneJumpDate();

  // Added in Phoebe
  public Date getLastRespecDate();

  // Added in Phoebe
  public Date getLastTimedRespec();

  // Added in Phoebe
  public int getFreeRespecs();

  // Added in Phoebe
  public int getFreeSkillPoints();

  // Added in Phoebe
  public int getCloneTypeID();

  // Added in Phoebe
  public Date getRemoteStationDate();

  // Added in Phoebe
  public Date getJumpActivation();

  // Added in Phoebe
  public Date getJumpFatigue();

  // Added in Phoebe
  public Date getJumpLastUpdate();

  // Added in Phoebe
  public List<IImplant> getImplants();

  // Added in Phoebe
  public List<IJumpClone> getJumpClones();

  // Added in Phoebe
  public List<IJumpCloneImplant> getJumpCloneImplants();
}
