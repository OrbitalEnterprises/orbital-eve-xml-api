package enterprises.orbital.evexmlapi.crp;

public interface IOutpost {
  public long getStationID();

  public long getOwnerID();

  public String getStationName();

  public long getSolarSystemID();

  public double getDockingCostPerShipVolume();

  public double getOfficeRentalCost();

  public int getStationTypeID();

  public double getReprocessingEfficiency();

  public double getReprocessingStationTake();

  public long getStandingOwnerID();

  public long getX();

  public long getY();

  public long getZ();
}
