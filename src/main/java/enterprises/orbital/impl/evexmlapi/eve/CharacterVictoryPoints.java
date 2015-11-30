package enterprises.orbital.impl.evexmlapi.eve;

import enterprises.orbital.evexmlapi.eve.ICharacterVictoryPointStat;

public class CharacterVictoryPoints extends CharacterStat implements VictoryPointsStat, ICharacterVictoryPointStat {
  private int victoryPoints;

  @Override
  public int getVictoryPoints() {
    return victoryPoints;
  }

  public void setVictoryPoints(int victoryPoints) {
    this.victoryPoints = victoryPoints;
  }
}