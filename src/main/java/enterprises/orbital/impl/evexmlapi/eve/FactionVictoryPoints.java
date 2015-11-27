package enterprises.orbital.impl.evexmlapi.eve;

import enterprises.orbital.evexmlapi.eve.IFactionVictoryPointStat;

public class FactionVictoryPoints extends FactionStat implements VictoryPointsStat, IFactionVictoryPointStat {
  private int victoryPoints;

  @Override
  public int getVictoryPoints() {
    return victoryPoints;
  }

  public void setVictoryPoints(int victoryPoints) {
    this.victoryPoints = victoryPoints;
  }
}