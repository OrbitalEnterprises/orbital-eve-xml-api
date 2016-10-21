package enterprises.orbital.impl.evexmlapi.eve;

import enterprises.orbital.evexmlapi.eve.IFactionStats;

public class ApiFactionStats implements IFactionStats {
  private long   factionID;
  private String factionName;
  private int    pilots;
  private int    systemsControlled;
  private int    killsYesterday;
  private int    killsLastWeek;
  private int    killsTotal;
  private int    victoryPointsYesterday;
  private int    victoryPointsLastWeek;
  private int    victoryPointsTotal;

  @Override
  public long getFactionID() {
    return factionID;
  }

  public void setFactionID(
                           long factionID) {
    this.factionID = factionID;
  }

  @Override
  public String getFactionName() {
    return factionName;
  }

  public void setFactionName(
                             String factionName) {
    this.factionName = factionName;
  }

  @Override
  public int getPilots() {
    return pilots;
  }

  public void setPilots(
                        int pilots) {
    this.pilots = pilots;
  }

  @Override
  public int getSystemsControlled() {
    return systemsControlled;
  }

  public void setSystemsControlled(
                                   int systemsControlled) {
    this.systemsControlled = systemsControlled;
  }

  @Override
  public int getKillsYesterday() {
    return killsYesterday;
  }

  public void setKillsYesterday(
                                int killsYesterday) {
    this.killsYesterday = killsYesterday;
  }

  @Override
  public int getKillsLastWeek() {
    return killsLastWeek;
  }

  public void setKillsLastWeek(
                               int killsLastWeek) {
    this.killsLastWeek = killsLastWeek;
  }

  @Override
  public int getKillsTotal() {
    return killsTotal;
  }

  public void setKillsTotal(
                            int killsTotal) {
    this.killsTotal = killsTotal;
  }

  @Override
  public int getVictoryPointsYesterday() {
    return victoryPointsYesterday;
  }

  public void setVictoryPointsYesterday(
                                        int victoryPointsYesterday) {
    this.victoryPointsYesterday = victoryPointsYesterday;
  }

  @Override
  public int getVictoryPointsLastWeek() {
    return victoryPointsLastWeek;
  }

  public void setVictoryPointsLastWeek(
                                       int victoryPointsLastWeek) {
    this.victoryPointsLastWeek = victoryPointsLastWeek;
  }

  @Override
  public int getVictoryPointsTotal() {
    return victoryPointsTotal;
  }

  public void setVictoryPointsTotal(
                                    int victoryPointsTotal) {
    this.victoryPointsTotal = victoryPointsTotal;
  }
}