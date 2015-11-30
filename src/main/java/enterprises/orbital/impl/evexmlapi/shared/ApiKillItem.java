package enterprises.orbital.impl.evexmlapi.shared;

import java.util.Collection;
import java.util.HashSet;

import enterprises.orbital.evexmlapi.shared.IKillItem;

public class ApiKillItem implements IKillItem {
  private final Collection<ApiKillItem> items = new HashSet<ApiKillItem>();
  private int                           typeID;
  private int                           flag;
  private int                           qtyDropped;
  private int                           qtyDestroyed;
  private boolean                       singleton;

  @Override
  public Collection<IKillItem> getContainedItems() {
    Collection<IKillItem> result = new HashSet<IKillItem>();
    result.addAll(items);
    return result;
  }

  public void addKillDetail(ApiKillItem item) {
    items.add(item);
  }

  @Override
  public boolean isSingleton() {
    return singleton;
  }

  public void setSingleton(boolean singleton) {
    this.singleton = singleton;
  }

  @Override
  public int getTypeID() {
    return typeID;
  }

  public void setTypeID(int typeID) {
    this.typeID = typeID;
  }

  @Override
  public int getFlag() {
    return flag;
  }

  public void setFlag(int flag) {
    this.flag = flag;
  }

  @Override
  public int getQtyDropped() {
    return qtyDropped;
  }

  public void setQtyDropped(int qtyDropped) {
    this.qtyDropped = qtyDropped;
  }

  @Override
  public int getQtyDestroyed() {
    return qtyDestroyed;
  }

  public void setQtyDestroyed(int qtyDestroyed) {
    this.qtyDestroyed = qtyDestroyed;
  }
}