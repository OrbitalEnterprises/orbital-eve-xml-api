package enterprises.orbital.impl.evexmlapi.eve;

import enterprises.orbital.evexmlapi.eve.ICharacterKillStat;

public class CharacterKills extends CharacterStat implements KillStat, ICharacterKillStat {
  private int kills;

  @Override
  public int getKills() {
    return kills;
  }

  public void setKills(int kills) {
    this.kills = kills;
  }
}