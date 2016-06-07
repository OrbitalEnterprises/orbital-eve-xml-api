package enterprises.orbital.evexmlapi.chr;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(
    as = IPartialCharacterSheet.class)
public interface IPartialCharacterSheet {
  public Date getDoB();

  public String getRace();

  public int getBloodlineID();

  public String getBloodline();

  public int getAncestryID();

  public String getAncestry();

  public String getGender();

  public int getFreeRespecs();

  public Date getCloneJumpDate();

  public Date getLastRespecDate();

  public Date getLastTimedRespec();

  public Date getRemoteStationDate();

  public int getIntelligence();

  public int getMemory();

  public int getCharisma();

  public int getPerception();

  public int getWillpower();

  public List<IImplant> getImplants();

  public List<IJumpClone> getJumpClones();

  public List<IJumpCloneImplant> getJumpCloneImplants();

  public Date getJumpActivation();

  public Date getJumpFatigue();

  public Date getJumpLastUpdate();

}
