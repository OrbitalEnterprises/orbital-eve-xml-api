package enterprises.orbital.evexmlapi.shared;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IFacWarStats.class)
public interface IFacWarStats {
  public int getCurrentRank();

  public Date getEnlisted();

  public int getFactionID();

  public String getFactionName();

  public int getHighestRank();

  public int getKillsLastWeek();

  public int getKillsTotal();

  public int getKillsYesterday();

  public int getPilots();

  public int getVictoryPointsLastWeek();

  public int getVictoryPointsTotal();

  public int getVictoryPointsYesterday();
}
