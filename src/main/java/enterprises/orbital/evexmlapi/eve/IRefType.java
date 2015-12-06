package enterprises.orbital.evexmlapi.eve;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IRefType.class)
public interface IRefType {
  public int getRefTypeID();

  public String getRefTypeName();
}
