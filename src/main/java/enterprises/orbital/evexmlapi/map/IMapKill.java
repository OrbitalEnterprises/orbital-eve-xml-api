package enterprises.orbital.evexmlapi.map;

import java.util.Collection;
import java.util.Date;

public interface IMapKill {
  public Date getDataTime();

  public Collection<ISystemKills> getKills();
}
