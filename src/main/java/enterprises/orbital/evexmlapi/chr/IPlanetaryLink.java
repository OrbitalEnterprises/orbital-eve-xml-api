package enterprises.orbital.evexmlapi.chr;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IPlanetaryLink.class)
public interface IPlanetaryLink {
  public long getSourcePinID();

  public long getDestinationPinID();

  public int getLinkLevel();
}
