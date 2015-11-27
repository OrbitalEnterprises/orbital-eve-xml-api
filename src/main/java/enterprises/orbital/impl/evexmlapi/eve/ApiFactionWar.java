package enterprises.orbital.impl.evexmlapi.eve;

import enterprises.orbital.evexmlapi.eve.IFactionWar;

public class ApiFactionWar implements IFactionWar {
  private int    factionID;
  private String factionName;
  private int    againstID;
  private String againstName;

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
  public int getAgainstID() {
    return againstID;
  }

  public void setAgainstID(int againstID) {
    this.againstID = againstID;
  }

  @Override
  public String getAgainstName() {
    return againstName;
  }

  public void setAgainstName(String againstName) {
    this.againstName = againstName;
  }
}