package enterprises.orbital.evexmlapi.eve;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IFactionWar.class)
public interface IFactionWar {
  public int getAgainstID();

  public String getAgainstName();

  public int getFactionID();

  public String getFactionName();
}
