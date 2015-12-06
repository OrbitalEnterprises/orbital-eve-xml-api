package enterprises.orbital.evexmlapi.shared;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IStanding.class)
public interface IStanding {
  public int getFromID();

  public String getFromName();

  public double getStanding();
}
