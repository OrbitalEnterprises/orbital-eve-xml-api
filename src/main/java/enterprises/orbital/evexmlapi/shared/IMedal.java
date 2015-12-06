package enterprises.orbital.evexmlapi.shared;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IMedal.class)
public interface IMedal {
  public String getDescription();

  public int getMedalID();

  public String getTitle();
}
