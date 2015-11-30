package enterprises.orbital.evexmlapi.act;

import java.util.Date;
import java.util.List;

/**
 * A response to a request for EVE Account Status.
 */
public interface IAccountStatus {
  public Date getPaidUntil();

  public Date getCreateDate();

  public int getLogonCount();

  public int getLogonMinutes();

  public List<IMultiCharacterTraining> getMultiCharacterTraining();

}
