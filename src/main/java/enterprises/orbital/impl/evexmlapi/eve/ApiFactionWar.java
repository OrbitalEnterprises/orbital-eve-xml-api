package enterprises.orbital.impl.evexmlapi.eve;

import enterprises.orbital.evexmlapi.eve.IFactionWar;

public class ApiFactionWar implements IFactionWar {
  private long   factionID;
  private String factionName;
  private long   againstID;
  private String againstName;

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
  public long getAgainstID() {
    return againstID;
  }

  public void setAgainstID(
                           long againstID) {
    this.againstID = againstID;
  }

  @Override
  public String getAgainstName() {
    return againstName;
  }

  public void setAgainstName(
                             String againstName) {
    this.againstName = againstName;
  }
}