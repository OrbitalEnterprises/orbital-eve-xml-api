package enterprises.orbital.impl.evexmlapi.map;

import java.io.IOException;
import java.util.Collection;

import enterprises.orbital.evexmlapi.map.IFacWarSystem;
import enterprises.orbital.evexmlapi.map.IMapAPI;
import enterprises.orbital.evexmlapi.map.IMapJump;
import enterprises.orbital.evexmlapi.map.IMapKill;
import enterprises.orbital.evexmlapi.map.ISovereignty;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.ApiConnector;

public class MapAPIAdapter extends AbstractAPIRequestAdapter implements IMapAPI {

  public MapAPIAdapter(ApiConnector connector) {
    super(connector);
  }

  @Override
  public Collection<IFacWarSystem> requestFacWarSystems() throws IOException {
    return new FacWarSystemsParser(connector).retrieveResponse(this);
  }

  @Override
  public IMapJump requestJumps() throws IOException {
    return new MapJumpsParser(connector).retrieveResponse(this);
  }

  @Override
  public IMapKill requestKills() throws IOException {
    return new MapKillsParser(connector).retrieveResponse(this);
  }

  @Override
  public ISovereignty requestSovereignty() throws IOException {
    return new MapSovereigntyParser(connector).retrieveResponse(this);
  }

}
