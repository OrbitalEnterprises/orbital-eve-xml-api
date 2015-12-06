package enterprises.orbital.evexmlapi.eve;

import java.util.Collection;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IFacWarTopStats.class)
public interface IFacWarTopStats<K extends IKillStat, VP extends IVictoryPointStat> {
  public Collection<K> getKillsLastWeek();

  public Collection<K> getKillsTotal();

  public Collection<K> getKillsYesterday();

  public Collection<VP> getVictoryPointsLastWeek();

  public Collection<VP> getVictoryPointsTotal();

  public Collection<VP> getVictoryPointsYesterday();
}
