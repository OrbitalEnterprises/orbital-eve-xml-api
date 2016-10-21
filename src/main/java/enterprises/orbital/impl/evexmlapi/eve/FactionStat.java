package enterprises.orbital.impl.evexmlapi.eve;

public abstract class FactionStat implements FacWarStat {
  private long   factionID;
  private String factionName;

  public long getFactionID() {
    return factionID;
  }

  public void setFactionID(
                           long factionID) {
    this.factionID = factionID;
  }

  public String getFactionName() {
    return factionName;
  }

  public void setFactionName(
                             String factionName) {
    this.factionName = factionName;
  }
}