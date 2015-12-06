package enterprises.orbital.evexmlapi.crp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = ISecurityTitle.class)
public interface ISecurityTitle {
  public long getTitleID();

  public String getTitleName();
}
