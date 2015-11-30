package enterprises.orbital.evexmlapi.map;

import java.io.IOException;
import java.util.Collection;

import enterprises.orbital.evexmlapi.IResponse;

public interface IMapAPI extends IResponse {

	public Collection<IFacWarSystem> requestFacWarSystems() throws IOException;

	public IMapJump requestJumps() throws IOException;

	public IMapKill requestKills() throws IOException;

	public ISovereignty requestSovereignty() throws IOException;
}
