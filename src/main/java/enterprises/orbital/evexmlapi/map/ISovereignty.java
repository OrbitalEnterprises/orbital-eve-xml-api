package enterprises.orbital.evexmlapi.map;

import java.util.Collection;
import java.util.Date;

public interface ISovereignty {

  public Date getDataTime();

  public Collection<ISystemSovereignty> getSystemSovereignty();
}
