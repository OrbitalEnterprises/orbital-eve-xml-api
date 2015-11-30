package enterprises.orbital.impl.evexmlapi.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import enterprises.orbital.evexmlapi.map.IJump;
import enterprises.orbital.evexmlapi.map.IMapJump;
import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class MapJumpsResponse extends ApiResponse implements IMapJump {
  private Date        dataTime;
  private List<IJump> jumps = new ArrayList<IJump>();

  @Override
  public Date getDataTime() {
    return dataTime;
  }

  public void setDataTime(Date dataTime) {
    this.dataTime = dataTime;
  }

  public void addSystemJumps(ApiSystemJumps systemJump) {
    jumps.add(systemJump);
  }

  @Override
  public Collection<IJump> getJumps() {
    return jumps;
  }

}
