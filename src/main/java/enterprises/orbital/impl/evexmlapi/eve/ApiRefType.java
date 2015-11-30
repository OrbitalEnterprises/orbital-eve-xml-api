package enterprises.orbital.impl.evexmlapi.eve;

import enterprises.orbital.evexmlapi.eve.IRefType;

public class ApiRefType implements IRefType {
  private int    refTypeID;
  private String refTypeName;

  @Override
  public int getRefTypeID() {
    return refTypeID;
  }

  public void setRefTypeID(int refTypeID) {
    this.refTypeID = refTypeID;
  }

  @Override
  public String getRefTypeName() {
    return refTypeName;
  }

  public void setRefTypeName(String refTypeName) {
    this.refTypeName = refTypeName;
  }
}