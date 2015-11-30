package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.evexmlapi.chr.IMailList;

public class ApiMailingList implements IMailList {
  private long   listID;
  private String displayName;

  @Override
  public long getListID() {
    return listID;
  }

  public void setListID(long listID) {
    this.listID = listID;
  }

  @Override
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }
}