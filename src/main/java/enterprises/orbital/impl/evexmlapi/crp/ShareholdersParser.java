package enterprises.orbital.impl.evexmlapi.crp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.crp.IShareholder;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class ShareholdersParser extends AbstractApiParser<ShareholdersResponse, Collection<IShareholder>> {
  public ShareholdersParser(ApiConnector connector) {
    super(connector, ShareholdersResponse.class, ApiEndpoint.CRP_SHAREHOLDERS_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiShareholder.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addShareholder");
    return digester;
  }

  @Override
  public Collection<IShareholder> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    ShareholdersResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IShareholder> result = new ArrayList<IShareholder>();
    result.addAll(response.getCharacters());
    result.addAll(response.getCorporations());
    return result;
  }

}