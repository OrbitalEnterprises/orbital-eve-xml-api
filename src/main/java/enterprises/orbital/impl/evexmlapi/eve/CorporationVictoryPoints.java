package enterprises.orbital.impl.evexmlapi.eve;

import enterprises.orbital.evexmlapi.eve.ICorporationVictoryPointStat;

public class CorporationVictoryPoints extends CorporationStat implements VictoryPointsStat, ICorporationVictoryPointStat {
  private int victoryPoints;

  @Override
  public int getVictoryPoints() {
    return victoryPoints;
  }

  public void setVictoryPoints(int victoryPoints) {
    this.victoryPoints = victoryPoints;
  }
}