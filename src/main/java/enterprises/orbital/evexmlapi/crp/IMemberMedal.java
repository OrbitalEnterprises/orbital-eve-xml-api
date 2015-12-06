package enterprises.orbital.evexmlapi.crp;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IMemberMedal.class)
public interface IMemberMedal {
  public long getCharacterID();

  public Date getIssued();

  public long getIssuerID();

  public int getMedalID();

  public String getReason();

  public String getStatus();
}
