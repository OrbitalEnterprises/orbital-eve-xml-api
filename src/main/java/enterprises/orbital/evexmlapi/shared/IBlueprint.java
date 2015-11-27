package enterprises.orbital.evexmlapi.shared;

public interface IBlueprint {

  public long getItemID();

  public long getLocationID();

  public int getTypeID();

  public String getTypeName();

  public int getFlagID();

  public int getQuantity();

  public int getTimeEfficiency();

  public int getMaterialEfficiency();

  public int getRuns();

}
