package enterprises.orbital.evexmlapi.api;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(
    as = ICallGroup.class)
public interface ICallGroup {
  public long getGroupID();

  public String getName();

  public String getDescription();
}
