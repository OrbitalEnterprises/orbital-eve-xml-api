package enterprises.orbital.impl.evexmlapi.crp;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.crp.IOutpost;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class OutpostListParser extends AbstractApiParser<OutpostListResponse, Collection<IOutpost>> {
  public OutpostListParser(ApiConnector connector) {
    super(connector, OutpostListResponse.class, ApiEndpoint.CRP_OUTPOST_LIST_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiOutpost.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addOutpost");
    return digester;
  }

  @Override
  public Collection<IOutpost> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    OutpostListResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IOutpost> result = new HashSet<IOutpost>();
    result.addAll(response.getOutposts());
    return result;
  }

}