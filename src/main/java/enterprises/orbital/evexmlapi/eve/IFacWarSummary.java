package enterprises.orbital.evexmlapi.eve;

import java.util.Collection;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IFacWarSummary.class)
public interface IFacWarSummary {

  public Collection<IFactionStats> getFactions();

  public int getKillsLastWeek();

  public int getKillsTotal();

  public int getKillsYesterday();

  public int getVictoryPointsLastWeek();

  public int getVictoryPointsTotal();

  public int getVictoryPointsYesterday();

  public Collection<IFactionWar> getWars();
}
