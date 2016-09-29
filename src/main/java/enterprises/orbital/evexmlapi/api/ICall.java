package enterprises.orbital.evexmlapi.api;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(
    as = ICall.class)
public interface ICall {
  public long getAccessMask();

  public String getType();

  public String getName();

  public long getGroupID();

  public String getDescription();
}
