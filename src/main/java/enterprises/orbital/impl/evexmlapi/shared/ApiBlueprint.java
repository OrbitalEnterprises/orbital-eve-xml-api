package enterprises.orbital.impl.evexmlapi.shared;

import enterprises.orbital.evexmlapi.shared.IBlueprint;

public class ApiBlueprint implements IBlueprint {
  private long   itemID;
  private long   locationID;
  private int    typeID;
  private String typeName;
  private int    flagID;
  private int    quantity;
  private int    timeEfficiency;
  private int    materialEfficiency;
  private int    runs;

  @Override
  public long getItemID() {
    return itemID;
  }

  public void setItemID(long itemID) {
    this.itemID = itemID;
  }

  @Override
  public long getLocationID() {
    return locationID;
  }

  public void setLocationID(long locationID) {
    this.locationID = locationID;
  }

  @Override
  public int getTypeID() {
    return typeID;
  }

  public void setTypeID(int typeID) {
    this.typeID = typeID;
  }

  @Override
  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  @Override
  public int getFlagID() {
    return flagID;
  }

  public void setFlagID(int flagID) {
    this.flagID = flagID;
  }

  @Override
  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public int getTimeEfficiency() {
    return timeEfficiency;
  }

  public void setTimeEfficiency(int timeEfficiency) {
    this.timeEfficiency = timeEfficiency;
  }

  @Override
  public int getMaterialEfficiency() {
    return materialEfficiency;
  }

  public void setMaterialEfficiency(int materialEfficiency) {
    this.materialEfficiency = materialEfficiency;
  }

  @Override
  public int getRuns() {
    return runs;
  }

  public void setRuns(int runs) {
    this.runs = runs;
  }

}