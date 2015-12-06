package enterprises.orbital.evexmlapi.shared;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IBlueprint.class)
public interface IBlueprint {

  public long getItemID();

  public long getLocationID();

  public int getTypeID();

  public String getTypeName();

  public int getFlagID();

  public int getQuantity();

  public int getTimeEfficiency();

  public int getMaterialEfficiency();

  public int getRuns();

}
