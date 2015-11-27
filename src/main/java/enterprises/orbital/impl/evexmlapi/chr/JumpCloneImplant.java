package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.evexmlapi.chr.IJumpCloneImplant;

public class JumpCloneImplant implements IJumpCloneImplant {
  private int    jumpCloneID = 0;
  private int    typeID      = 0;
  private String typeName    = null;

  @Override
  public int getJumpCloneID() {
    return jumpCloneID;
  }

  public void setJumpCloneID(int jumpCloneID) {
    this.jumpCloneID = jumpCloneID;
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

}
