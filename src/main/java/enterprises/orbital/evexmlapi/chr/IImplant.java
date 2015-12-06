package enterprises.orbital.evexmlapi.chr;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IImplant.class)
public interface IImplant {
  public int getTypeID();

  public String getTypeName();
}
