package enterprises.orbital.evexmlapi.chr;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IJumpClone.class)
public interface IJumpClone {
  public int getJumpCloneID();

  public int getTypeID();

  public long getLocationID();

  public String getCloneName();
}
