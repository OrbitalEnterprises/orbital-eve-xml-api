package enterprises.orbital.evexmlapi.crp;

import java.util.Date;

public interface IMemberMedal {
  public long getCharacterID();

  public Date getIssued();

  public long getIssuerID();

  public int getMedalID();

  public String getReason();

  public String getStatus();
}
