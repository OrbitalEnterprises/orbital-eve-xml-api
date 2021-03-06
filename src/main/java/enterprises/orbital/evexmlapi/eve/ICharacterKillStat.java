package enterprises.orbital.evexmlapi.eve;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(
    as = ICharacterKillStat.class)
public interface ICharacterKillStat extends IKillStat {
  public long getCharacterID();

  public String getCharacterName();
}
