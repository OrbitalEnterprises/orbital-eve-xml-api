package enterprises.orbital.impl.evexmlapi.eve;

import enterprises.orbital.evexmlapi.eve.ICorporationKillStat;

public class CorporationKills extends CorporationStat implements KillStat, ICorporationKillStat {
  private int kills;

  @Override
  public int getKills() {
    return kills;
  }

  public void setKills(int kills) {
    this.kills = kills;
  }
}