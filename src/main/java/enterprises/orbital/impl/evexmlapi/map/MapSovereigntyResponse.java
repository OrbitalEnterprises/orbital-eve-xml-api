package enterprises.orbital.impl.evexmlapi.map;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import enterprises.orbital.evexmlapi.map.ISovereignty;
import enterprises.orbital.evexmlapi.map.ISystemSovereignty;
import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class MapSovereigntyResponse extends ApiResponse implements ISovereignty {
  private static final long              serialVersionUID    = 1829486253240286894L;
  private final List<ISystemSovereignty> systemSovereignties = new ArrayList<ISystemSovereignty>();
  private Date                           dataTime;

  public void addSystemSovereignty(ApiSystemSovereignty systemSovereignty) {
    systemSovereignties.add(systemSovereignty);
  }

  @Override
  public Date getDataTime() {
    return dataTime;
  }

  public void setDataTime(Date dataTime) {
    this.dataTime = dataTime;
  }

  @Override
  public Collection<ISystemSovereignty> getSystemSovereignty() {
    return systemSovereignties;
  }

}
