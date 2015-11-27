package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.evexmlapi.chr.IJumpClone;

public class JumpClone implements IJumpClone {
  private int    jumpCloneID = 0;
  private int    typeID      = 0;
  private long   locationID  = 0;
  private String cloneName   = null;

  public int getJumpCloneID() {
    return jumpCloneID;
  }

  public void setJumpCloneID(int jumpCloneID) {
    this.jumpCloneID = jumpCloneID;
  }

  public int getTypeID() {
    return typeID;
  }

  public void setTypeID(int typeID) {
    this.typeID = typeID;
  }

  public long getLocationID() {
    return locationID;
  }

  public void setLocationID(long locationID) {
    this.locationID = locationID;
  }

  public String getCloneName() {
    return cloneName;
  }

  public void setCloneName(String cloneName) {
    this.cloneName = cloneName;
  }

}
