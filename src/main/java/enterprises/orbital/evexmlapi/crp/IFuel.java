package enterprises.orbital.evexmlapi.crp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IFuel.class)
public interface IFuel {
  public int getQuantity();

  public int getTypeID();
}
