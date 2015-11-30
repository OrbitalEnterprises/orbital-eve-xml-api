package enterprises.orbital.evexmlapi.api;

import java.io.IOException;

import enterprises.orbital.evexmlapi.IResponse;

public interface IApiAPI extends IResponse {

  public ICallList requestCallList() throws IOException;

}
