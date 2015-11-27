package enterprises.orbital.impl.evexmlapi.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import enterprises.orbital.evexmlapi.map.IMapKill;
import enterprises.orbital.evexmlapi.map.ISystemKills;
import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class MapKillsResponse extends ApiResponse implements IMapKill {
  private static final long        serialVersionUID = 1L;
  private final List<ISystemKills> kills            = new ArrayList<ISystemKills>();
  private Date                     dataTime;

  @Override
  public Date getDataTime() {
    return dataTime;
  }

  public void setDataTime(Date dataTime) {
    this.dataTime = dataTime;
  }

  public void addSystemKills(ApiSystemKills systemKills) {
    kills.add(systemKills);
  }

  @Override
  public Collection<ISystemKills> getKills() {
    return kills;
  }

}
