package enterprises.orbital.evexmlapi.map;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IMapKill.class)
public interface IMapKill {
  public Date getDataTime();

  public Collection<ISystemKills> getKills();
}
