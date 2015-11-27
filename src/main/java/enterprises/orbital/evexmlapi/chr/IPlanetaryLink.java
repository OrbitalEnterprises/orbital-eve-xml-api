package enterprises.orbital.evexmlapi.chr;

public interface IPlanetaryLink {
  public long getSourcePinID();

  public long getDestinationPinID();

  public int getLinkLevel();
}
