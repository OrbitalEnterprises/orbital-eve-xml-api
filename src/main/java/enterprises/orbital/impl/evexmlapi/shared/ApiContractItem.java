package enterprises.orbital.impl.evexmlapi.shared;

import enterprises.orbital.evexmlapi.shared.IContractItem;

public class ApiContractItem implements IContractItem {
  private long    recordID;
  private int     typeID;
  private long    quantity;
  private long    rawQuantity;
  private boolean singleton;
  private boolean included;

  @Override
  public long getRecordID() {
    return recordID;
  }

  public void setRecordID(
                          long recordID) {
    this.recordID = recordID;
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
  public long getRawQuantity() {
    return rawQuantity;
  }

  public void setRawQuantity(
                             long rawQuantity) {
    this.rawQuantity = rawQuantity;
  }

  @Override
  public boolean isSingleton() {
    return singleton;
  }

  public void setSingleton(
                           boolean singleton) {
    this.singleton = singleton;
  }

  @Override
  public boolean isIncluded() {
    return included;
  }

  public void setIncluded(
                          boolean included) {
    this.included = included;
  }

}