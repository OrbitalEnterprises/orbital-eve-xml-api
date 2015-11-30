package enterprises.orbital.evexmlapi.svr;

import java.io.IOException;

import enterprises.orbital.evexmlapi.IResponse;

public interface IServerAPI extends IResponse {

	public IServerStatus requestServerStatus() throws IOException;

}
