package enterprises.orbital.evexmlapi.eve;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = ICorporationKillStat.class)
public interface ICorporationKillStat extends IKillStat {
  public long getCorporationID();

  public String getCorporationName();
}
