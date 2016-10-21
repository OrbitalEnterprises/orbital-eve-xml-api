package enterprises.orbital.evexmlapi.map;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(
    as = IFacWarSystem.class)
public interface IFacWarSystem {
  public long getOccupyingFactionID();

  public String getOccupyingFactionName();

  public long getOwningFactionID();

  public String getOwningFactionName();

  public int getSolarSystemID();

  public String getSolarSystemName();

  public boolean isContested();
}
