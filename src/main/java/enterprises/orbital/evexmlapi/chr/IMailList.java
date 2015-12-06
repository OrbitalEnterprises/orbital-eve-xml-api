package enterprises.orbital.evexmlapi.chr;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IMailList.class)
public interface IMailList {
  public String getDisplayName();

  public long getListID();
}
