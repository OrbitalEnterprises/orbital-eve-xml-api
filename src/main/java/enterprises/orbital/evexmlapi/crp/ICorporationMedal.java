package enterprises.orbital.evexmlapi.crp;

import java.util.Date;

import enterprises.orbital.evexmlapi.shared.IMedal;

public interface ICorporationMedal extends IMedal {
  public Date getCreated();

  public long getCreatorID();
}
