package enterprises.orbital.impl.evexmlapi.api;

import enterprises.orbital.evexmlapi.api.ICall;
import enterprises.orbital.evexmlapi.api.ICallGroup;

public class ApiCallOrGroup {
  private long   groupID;
  private String name;
  private String description;
  private long   accessMask;
  private String type;

  public long getGroupID() {
    return groupID;
  }

  public void setGroupID(
                         long groupID) {
    this.groupID = groupID;
  }

  public String getName() {
    return name;
  }

  public void setName(
                      String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(
                             String description) {
    this.description = description;
  }

  public long getAccessMask() {
    return accessMask;
  }

  public void setAccessMask(
                            long accessMask) {
    this.accessMask = accessMask;
  }

  public String getType() {
    return type;
  }

  public void setType(
                      String type) {
    this.type = type;
  }

  public ICall asCall() {
    return new ICall() {

      @Override
      public long getAccessMask() {
        return accessMask;
      }

      @Override
      public String getType() {
        return type;
      }

      @Override
      public String getName() {
        return name;
      }

      @Override
      public long getGroupID() {
        return groupID;
      }

      @Override
      public String getDescription() {
        return description;
      }

    };
  }

  public ICallGroup asCallGroup() {
    return new ICallGroup() {

      @Override
      public long getGroupID() {
        return groupID;
      }

      @Override
      public String getName() {
        return name;
      }

      @Override
      public String getDescription() {
        return description;
      }

    };
  }

}
