package enterprises.orbital.impl.evexmlapi.svr;

import java.io.IOException;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.svr.IServerStatus;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class ServerStatusParser extends AbstractApiParser<ServerStatusResponse, IServerStatus> {
  public ServerStatusParser(ApiConnector connector) {
    super(connector, ServerStatusResponse.class, ApiEndpoint.SVR_SERVER_STATUS_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addBeanPropertySetter("eveapi/result/serverOpen");
    digester.addBeanPropertySetter("eveapi/result/onlinePlayers");
    return digester;
  }

  @Override
  public IServerStatus retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    ServerStatusResponse response = getResponse();
    adapter.setFromLastResponse(response);
    return adapter.isError() ? null : response;
  }
}