package enterprises.orbital.impl.evexmlapi.crp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.crp.IContainerLog;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class ContainerLogParser extends AbstractApiParser<ContainerLogResponse, Collection<IContainerLog>> {
  public ContainerLogParser() {
    super(ContainerLogResponse.class, ApiEndpoint.CRP_CONTAINER_LOG_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiContainerLog.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addContainerLog");
    return digester;
  }

  @Override
  public Collection<IContainerLog> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    ContainerLogResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IContainerLog> result = new ArrayList<IContainerLog>();
    result.addAll(response.getContainerLogs());
    return result;
  }

}