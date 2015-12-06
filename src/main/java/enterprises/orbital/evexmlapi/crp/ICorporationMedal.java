package enterprises.orbital.evexmlapi.crp;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import enterprises.orbital.evexmlapi.shared.IMedal;

@JsonSerialize(as = ICorporationMedal.class)
public interface ICorporationMedal extends IMedal {
  public Date getCreated();

  public long getCreatorID();
}
