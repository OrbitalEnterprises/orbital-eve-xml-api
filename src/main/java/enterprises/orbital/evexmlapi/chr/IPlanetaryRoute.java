package enterprises.orbital.evexmlapi.chr;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IPlanetaryRoute.class)
public interface IPlanetaryRoute {
  public long getRouteID();

  public long getSourcePinID();

  public long getDestinationPinID();

  public int getContentTypeID();

  public String getContentTypeName();

  public int getQuantity();

  public long getWaypoint1();

  public long getWaypoint2();

  public long getWaypoint3();

  public long getWaypoint4();

  public long getWaypoint5();
}
