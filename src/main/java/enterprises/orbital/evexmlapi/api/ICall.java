package enterprises.orbital.evexmlapi.api;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = ICall.class)
public interface ICall {
  public long getAccessMask();

  public String getType();

  public String getName();

  public int getGroupID();

  public String getDescription();
}
