package enterprises.orbital.evexmlapi.eve;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(
    as = ICharacterVictoryPointStat.class)
public interface ICharacterVictoryPointStat extends IVictoryPointStat {
  public long getCharacterID();

  public String getCharacterName();
}
