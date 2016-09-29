package enterprises.orbital.impl.evexmlapi.shared;

import java.util.Collection;
import java.util.HashSet;

import enterprises.orbital.evexmlapi.shared.IAsset;

public class ApiAsset implements IAsset {
  private final Collection<ApiAsset> assets = new HashSet<ApiAsset>();
  private long                       itemID;
  private long                       locationID;
  private int                        typeID;
  private long                       quantity;
  private int                        flag;
  private boolean                    singleton;
  private long                       rawQuantity;

  @Override
  public long getRawQuantity() {
    return rawQuantity;
  }

  public void setRawQuantity(
                             long rawQuantity) {
    this.rawQuantity = rawQuantity;
  }

  @Override
  public Collection<IAsset> getContainedAssets() {
    Collection<IAsset> result = new HashSet<IAsset>();
    result.addAll(assets);
    return result;
  }

  public void addAsset(
                       ApiAsset asset) {
    assets.add(asset);
  }

  @Override
  public long getItemID() {
    return itemID;
  }

  public void setItemID(
                        long itemID) {
    this.itemID = itemID;
  }

  @Override
  public long getLocationID() {
    return locationID;
  }

  public void setLocationID(
                            long locationID) {
    this.locationID = locationID;
  }

  @Override
  public int getTypeID() {
    return typeID;
  }

  public void setTypeID(
                        int typeID) {
    this.typeID = typeID;
  }

  @Override
  public long getQuantity() {
    return quantity;
  }

  public void setQuantity(
                          long quantity) {
    this.quantity = quantity;
  }

  @Override
  public int getFlag() {
    return flag;
  }

  public void setFlag(
                      int flag) {
    this.flag = flag;
  }

  @Override
  public boolean isSingleton() {
    return singleton;
  }

  public void setSingleton(
                           boolean singleton) {
    this.singleton = singleton;
  }

}
