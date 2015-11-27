package enterprises.orbital.evexmlapi.chr;

import java.util.Date;

import enterprises.orbital.evexmlapi.shared.IMedal;

public interface ICharacterMedal extends IMedal {
  public long getCorporationID();

  public Date getIssued();

  public long getIssuerID();

  public String getReason();

  public String getStatus();
}
