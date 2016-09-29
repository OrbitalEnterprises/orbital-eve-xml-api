package enterprises.orbital.evexmlapi.act;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * A response to a request for EVE Account Status.
 */
@JsonSerialize(
    as = IAccountStatus.class)
public interface IAccountStatus {
  public Date getPaidUntil();

  public Date getCreateDate();

  public long getLogonCount();

  public long getLogonMinutes();

  public List<IMultiCharacterTraining> getMultiCharacterTraining();

}
