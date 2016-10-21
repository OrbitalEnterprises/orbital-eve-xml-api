package enterprises.orbital.evexmlapi.eve;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(
    as = IFactionStats.class)
public interface IFactionStats {
  public long getFactionID();

  public String getFactionName();

  public int getKillsLastWeek();

  public int getKillsTotal();

  public int getKillsYesterday();

  public int getPilots();

  public int getSystemsControlled();

  public int getVictoryPointsLastWeek();

  public int getVictoryPointsTotal();

  public int getVictoryPointsYesterday();
}
