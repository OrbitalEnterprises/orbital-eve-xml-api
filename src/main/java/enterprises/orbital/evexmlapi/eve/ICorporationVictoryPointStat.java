package enterprises.orbital.evexmlapi.eve;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = ICorporationVictoryPointStat.class)
public interface ICorporationVictoryPointStat extends IVictoryPointStat {
  public long getCorporationID();

  public String getCorporationName();
}
