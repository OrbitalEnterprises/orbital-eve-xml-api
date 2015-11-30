package enterprises.orbital.impl.evexmlapi.api;

import enterprises.orbital.evexmlapi.api.ICall;
import enterprises.orbital.evexmlapi.api.ICallGroup;

public class ApiCallOrGroup implements ICallGroup, ICall {
  private int    groupID;
  private String name;
  private String description;
  private long   accessMask;
  private String type;

  @Override
  public int getGroupID() {
    return groupID;
  }

  public void setGroupID(int groupID) {
    this.groupID = groupID;
  }

  @Override
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  @Override
  public long getAccessMask() {
    return accessMask;
  }

  public void setAccessMask(long accessMask) {
    this.accessMask = accessMask;
  }

  @Override
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

}
