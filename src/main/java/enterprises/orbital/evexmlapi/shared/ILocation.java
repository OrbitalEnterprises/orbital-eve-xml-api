package enterprises.orbital.evexmlapi.shared;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = ILocation.class)
public interface ILocation {
  public long getItemID();

  public String getItemName();

  public double getX();

  public double getY();

  public double getZ();
}
