package enterprises.orbital.evexmlapi.crp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IDivision.class)
public interface IDivision {
  public int getAccountKey();

  public String getDescription();
}
