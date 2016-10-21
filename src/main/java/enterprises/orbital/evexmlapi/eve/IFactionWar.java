package enterprises.orbital.evexmlapi.eve;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(
    as = IFactionWar.class)
public interface IFactionWar {
  public long getAgainstID();

  public String getAgainstName();

  public long getFactionID();

  public String getFactionName();
}
