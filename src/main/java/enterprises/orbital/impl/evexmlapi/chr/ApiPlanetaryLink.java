package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.evexmlapi.chr.IPlanetaryLink;

public class ApiPlanetaryLink implements IPlanetaryLink {
  private long sourcePinID;
  private long destinationPinID;
  private int  linkLevel;

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
  public int getLinkLevel() {
    return linkLevel;
  }

  public void setLinkLevel(int linkLevel) {
    this.linkLevel = linkLevel;
  }

}