package enterprises.orbital.impl.evexmlapi.shared;

import enterprises.orbital.evexmlapi.shared.ILocation;

public class ApiLocation implements ILocation {
  private long   itemID;
  private String itemName;
  private double x;
  private double y;
  private double z;

  @Override
  public long getItemID() {
    return itemID;
  }

  public void setItemID(long itemID) {
    this.itemID = itemID;
  }

  @Override
  public String getItemName() {
    return itemName;
  }

  public void setItemName(String itemName) {
    this.itemName = itemName;
  }

  @Override
  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  @Override
  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

  @Override
  public double getZ() {
    return z;
  }

  public void setZ(double z) {
    this.z = z;
  }

}
