package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.evexmlapi.chr.ICharacterTitle;

public class ApiCharacterTitle implements ICharacterTitle {
  private long   titleID;
  private String titleName;

  public long getTitleID() {
    return titleID;
  }

  public void setTitleID(long titleID) {
    this.titleID = titleID;
  }

  public String getTitleName() {
    return titleName;
  }

  public void setTitleName(String titleName) {
    this.titleName = titleName;
  }

}
