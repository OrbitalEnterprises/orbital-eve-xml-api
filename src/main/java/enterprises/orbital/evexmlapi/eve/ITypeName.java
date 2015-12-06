package enterprises.orbital.evexmlapi.eve;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = ITypeName.class)
public interface ITypeName {
  public int getTypeID();

  public String getTypeName();
}
