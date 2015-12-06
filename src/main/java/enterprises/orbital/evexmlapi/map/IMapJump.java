package enterprises.orbital.evexmlapi.map;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IMapJump.class)
public interface IMapJump {
  public Date getDataTime();

  public Collection<IJump> getJumps();
}
