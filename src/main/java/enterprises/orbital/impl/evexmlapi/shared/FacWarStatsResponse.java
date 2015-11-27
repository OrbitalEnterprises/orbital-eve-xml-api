package enterprises.orbital.impl.evexmlapi.shared;

import java.util.Date;

import enterprises.orbital.evexmlapi.shared.IFacWarStats;
import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class FacWarStatsResponse extends ApiResponse implements IFacWarStats {
  private static final long serialVersionUID = 799330788572201650L;
  private int               factionID;
  private String            factionName;
  private Date              enlisted;
  private int               currentRank;
  private int               highestRank;
  private int               killsYesterday;
  private int               killsLastWeek;
  private int               killsTotal;
  private int               victoryPointsYesterday;
  private int               victoryPointsLastWeek;
  private int               victoryPointsTotal;
  private int               pilots;

  @Override
  public int getFactionID() {
    return factionID;
  }

  public void setFactionID(int factionID) {
    this.factionID = factionID;
  }

  @Override
  public String getFactionName() {
    return factionName;
  }

  public void setFactionName(String factionName) {
    this.factionName = factionName;
  }

  @Override
  public Date getEnlisted() {
    return enlisted;
  }

  public void setEnlisted(Date enlisted) {
    this.enlisted = enlisted;
  }

  @Override
  public int getCurrentRank() {
    return currentRank;
  }

  public void setCurrentRank(int currentRank) {
    this.currentRank = currentRank;
  }

  @Override
  public int getHighestRank() {
    return highestRank;
  }

  public void setHighestRank(int highestRank) {
    this.highestRank = highestRank;
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

  @Override
  public int getPilots() {
    return pilots;
  }

  public void setPilots(int pilots) {
    this.pilots = pilots;
  }
}