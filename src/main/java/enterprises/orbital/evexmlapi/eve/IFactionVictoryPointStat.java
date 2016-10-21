package enterprises.orbital.evexmlapi.eve;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(
    as = IFactionVictoryPointStat.class)
public interface IFactionVictoryPointStat extends IVictoryPointStat {
  public long getFactionID();

  public String getFactionName();
}
