package enterprises.orbital.impl.evexmlapi.map;

import java.io.IOException;
import java.util.Collection;

import enterprises.orbital.evexmlapi.map.IFacWarSystem;
import enterprises.orbital.evexmlapi.map.IMapAPI;
import enterprises.orbital.evexmlapi.map.IMapJump;
import enterprises.orbital.evexmlapi.map.IMapKill;
import enterprises.orbital.evexmlapi.map.ISovereignty;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;

public class MapAPIAdapter extends AbstractAPIRequestAdapter implements IMapAPI {

  @Override
  public Collection<IFacWarSystem> requestFacWarSystems() throws IOException {
    return new FacWarSystemsParser().retrieveResponse(this);
  }

  @Override
  public IMapJump requestJumps() throws IOException {
    return new MapJumpsParser().retrieveResponse(this);
  }

  @Override
  public IMapKill requestKills() throws IOException {
    return new MapKillsParser().retrieveResponse(this);
  }

  @Override
  public ISovereignty requestSovereignty() throws IOException {
    return new MapSovereigntyParser().retrieveResponse(this);
  }

}
