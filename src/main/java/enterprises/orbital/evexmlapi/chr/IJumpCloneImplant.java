package enterprises.orbital.evexmlapi.chr;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IJumpCloneImplant.class)
public interface IJumpCloneImplant {
  public int getJumpCloneID();

  public int getTypeID();

  public String getTypeName();
}
