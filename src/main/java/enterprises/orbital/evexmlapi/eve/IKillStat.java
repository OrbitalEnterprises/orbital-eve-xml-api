package enterprises.orbital.evexmlapi.eve;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IKillStat.class)
public interface IKillStat {
  public int getKills();
}
