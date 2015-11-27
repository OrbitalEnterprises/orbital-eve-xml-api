package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.evexmlapi.chr.IPlanetaryRoute;

public class ApiPlanetaryRoute implements IPlanetaryRoute {
  private long   routeID;
  private long   sourcePinID;
  private long   destinationPinID;
  private int    contentTypeID;
  private String contentTypeName;
  private int    quantity;
  private long   waypoint1;
  private long   waypoint2;
  private long   waypoint3;
  private long   waypoint4;
  private long   waypoint5;

  @Override
  public long getRouteID() {
    return routeID;
  }

  public void setRouteID(long routeID) {
    this.routeID = routeID;
  }

  @Override
  public long getSourcePinID() {
    return sourcePinID;
  }

  public void setSourcePinID(long sourcePinID) {
    this.sourcePinID = sourcePinID;
  }

  @Override
  public long getDestinationPinID() {
    return destinationPinID;
  }

  public void setDestinationPinID(long destinationPinID) {
    this.destinationPinID = destinationPinID;
  }

  @Override
  public int getContentTypeID() {
    return contentTypeID;
  }

  public void setContentTypeID(int contentTypeID) {
    this.contentTypeID = contentTypeID;
  }

  @Override
  public String getContentTypeName() {
    return contentTypeName;
  }

  public void setContentTypeName(String contentTypeName) {
    this.contentTypeName = contentTypeName;
  }

  @Override
  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public long getWaypoint1() {
    return waypoint1;
  }

  public void setWaypoint1(long waypoint1) {
    this.waypoint1 = waypoint1;
  }

  @Override
  public long getWaypoint2() {
    return waypoint2;
  }

  public void setWaypoint2(long waypoint2) {
    this.waypoint2 = waypoint2;
  }

  @Override
  public long getWaypoint3() {
    return waypoint3;
  }

  public void setWaypoint3(long wayppint3) {
    this.waypoint3 = wayppint3;
  }

  @Override
  public long getWaypoint4() {
    return waypoint4;
  }

  public void setWaypoint4(long waypoint4) {
    this.waypoint4 = waypoint4;
  }

  @Override
  public long getWaypoint5() {
    return waypoint5;
  }

  public void setWaypoint5(long waypoint5) {
    this.waypoint5 = waypoint5;
  }

}