package enterprises.orbital.impl.evexmlapi.eve;

import java.util.ArrayList;
import java.util.List;

import enterprises.orbital.evexmlapi.eve.IFacWarSummary;
import enterprises.orbital.evexmlapi.eve.IFactionStats;
import enterprises.orbital.evexmlapi.eve.IFactionWar;
import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class EveFacWarStatsResponse extends ApiResponse implements IFacWarSummary {
  private static final long         serialVersionUID = 1L;
  private final List<IFactionStats> factions         = new ArrayList<IFactionStats>();
  private final List<IFactionWar>   wars             = new ArrayList<IFactionWar>();
  private int                       killsYesterday;
  private int                       killsLastWeek;
  private int                       killsTotal;
  private int                       victoryPointsYesterday;
  private int                       victoryPointsLastWeek;
  private int                       victoryPointsTotal;

  public void addStat(ApiFactionStats factionStats) {
    this.factions.add(factionStats);
  }

  public void addStat(ApiFactionWar factionWar) {
    wars.add(factionWar);
  }

  @Override
  public List<IFactionStats> getFactions() {
    return factions;
  }

  @Override
  public List<IFactionWar> getWars() {
    return wars;
  }

  @Override
  public int getKillsYesterday() {
    return killsYesterday;
  }

  public void setKillsYesterday(int killsYesterday) {
    this.killsYesterday = killsYesterday;
  }

  @Override
  public int getKillsLastWeek() {
    return killsLastWeek;
  }

  public void setKillsLastWeek(int killsLastWeek) {
    this.killsLastWeek = killsLastWeek;
  }

  @Override
  public int getKillsTotal() {
    return killsTotal;
  }

  public void setKillsTotal(int killsTotal) {
    this.killsTotal = killsTotal;
  }

  @Override
  public int getVictoryPointsYesterday() {
    return victoryPointsYesterday;
  }

  public void setVictoryPointsYesterday(int victoryPointsYesterday) {
    this.victoryPointsYesterday = victoryPointsYesterday;
  }

  @Override
  public int getVictoryPointsLastWeek() {
    return victoryPointsLastWeek;
  }

  public void setVictoryPointsLastWeek(int victoryPointsLastWeek) {
    this.victoryPointsLastWeek = victoryPointsLastWeek;
  }

  @Override
  public int getVictoryPointsTotal() {
    return victoryPointsTotal;
  }

  public void setVictoryPointsTotal(int victoryPointsTotal) {
    this.victoryPointsTotal = victoryPointsTotal;
  }
}