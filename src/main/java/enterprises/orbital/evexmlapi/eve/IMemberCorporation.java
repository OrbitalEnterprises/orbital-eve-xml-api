package enterprises.orbital.evexmlapi.eve;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IMemberCorporation.class)
public interface IMemberCorporation {
  public long getCorporationID();

  public Date getStartDate();
}
