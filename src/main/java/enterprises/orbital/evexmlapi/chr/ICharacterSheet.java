package enterprises.orbital.evexmlapi.chr;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = ICharacterSheet.class)
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

  public long getHomeStationID();

  public Date getCloneJumpDate();

  public Date getLastRespecDate();

  public Date getLastTimedRespec();

  public int getFreeRespecs();

  public int getFreeSkillPoints();

  public int getCloneTypeID();

  public Date getRemoteStationDate();

  public Date getJumpActivation();

  public Date getJumpFatigue();

  public Date getJumpLastUpdate();

  public List<IImplant> getImplants();

  public List<IJumpClone> getJumpClones();

  public List<IJumpCloneImplant> getJumpCloneImplants();
}
