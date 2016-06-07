package enterprises.orbital.evexmlapi.chr;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Set;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(
    as = ICharacterSheet.class)
public interface ICharacterSheet extends IPartialCharacterSheet {
  public long getCharacterID();

  public String getName();

  public long getHomeStationID();

  public String getCorporationName();

  public long getCorporationID();

  public String getAllianceName();

  public long getAllianceID();

  public String getFactionName();

  public long getFactionID();

  public int getCloneTypeID();

  public String getCloneName();

  public int getCloneSkillPoints();

  public int getFreeSkillPoints();

  public BigDecimal getBalance();

  public Set<ISkill> getSkills();

  public Collection<ICharacterRole> getRoles();

  public Collection<ICharacterTitle> getTitles();
}
