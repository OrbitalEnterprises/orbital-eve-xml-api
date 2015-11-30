package enterprises.orbital.impl.evexmlapi.eve;

import enterprises.orbital.evexmlapi.eve.IFactionKillStat;

public class FactionKills extends FactionStat implements KillStat, IFactionKillStat {
  private int kills;

  @Override
  public int getKills() {
    return kills;
  }

  public void setKills(int kills) {
    this.kills = kills;
  }
}