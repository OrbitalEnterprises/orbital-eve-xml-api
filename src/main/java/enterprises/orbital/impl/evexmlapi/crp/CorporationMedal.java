package enterprises.orbital.impl.evexmlapi.crp;

import java.util.Date;

import enterprises.orbital.evexmlapi.crp.ICorporationMedal;
import enterprises.orbital.impl.evexmlapi.shared.Medal;

public class CorporationMedal extends Medal implements ICorporationMedal {
  private long creatorID;
  private Date created;

  @Override
  public long getCreatorID() {
    return creatorID;
  }

  public void setCreatorID(long creatorID) {
    this.creatorID = creatorID;
  }

  @Override
  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }
}