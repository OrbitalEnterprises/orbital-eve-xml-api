package enterprises.orbital.evexmlapi.eve;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IVictoryPointStat.class)
public interface IVictoryPointStat {
  public int getVictoryPoints();
}
