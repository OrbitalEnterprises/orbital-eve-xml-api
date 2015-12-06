package enterprises.orbital.evexmlapi.map;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = ISovereignty.class)
public interface ISovereignty {

  public Date getDataTime();

  public Collection<ISystemSovereignty> getSystemSovereignty();
}
