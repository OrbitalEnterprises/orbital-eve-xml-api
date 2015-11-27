package enterprises.orbital.impl.evexmlapi.crp;

import enterprises.orbital.evexmlapi.crp.ISecurityTitle;

public class ApiSecurityTitle implements ISecurityTitle {
  private final long   titleID;
  private final String titleName;

  public ApiSecurityTitle(long titleID, String titleName) {
    this.titleID = titleID;
    this.titleName = titleName;
  }

  public long getTitleID() {
    return titleID;
  }

  public String getTitleName() {
    return titleName;
  }
}