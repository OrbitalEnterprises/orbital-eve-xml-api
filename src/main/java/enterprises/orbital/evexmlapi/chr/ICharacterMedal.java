package enterprises.orbital.evexmlapi.chr;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import enterprises.orbital.evexmlapi.shared.IMedal;

@JsonSerialize(as = ICharacterMedal.class)
public interface ICharacterMedal extends IMedal {
  public long getCorporationID();

  public Date getIssued();

  public long getIssuerID();

  public String getReason();

  public String getStatus();
}
