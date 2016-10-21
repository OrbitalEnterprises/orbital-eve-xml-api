package enterprises.orbital.evexmlapi.eve;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(
    as = IFactionKillStat.class)
public interface IFactionKillStat extends IKillStat {
  public long getFactionID();

  public String getFactionName();
}
