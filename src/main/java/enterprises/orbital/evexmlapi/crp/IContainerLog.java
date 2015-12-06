package enterprises.orbital.evexmlapi.crp;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IContainerLog.class)
public interface IContainerLog {
  public String getAction();

  public long getActorID();

  public String getActorName();

  public byte getFlag();

  public long getItemID();

  public long getItemTypeID();

  public int getLocationID();

  public Date getLogTime();

  public String getNewConfiguration();

  public String getOldConfiguration();

  public String getPasswordType();

  public int getQuantity();

  public long getTypeID();
}
