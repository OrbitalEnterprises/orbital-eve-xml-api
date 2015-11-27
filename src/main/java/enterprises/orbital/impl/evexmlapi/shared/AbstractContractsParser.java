package enterprises.orbital.impl.evexmlapi.shared;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.shared.IContract;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public abstract class AbstractContractsParser extends AbstractApiParser<ContractsResponse, Collection<IContract>> {
  protected AbstractContractsParser(ApiEndpoint endpoint) {
    super(ContractsResponse.class, endpoint);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiContract.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addContract");
    return digester;
  }

  @Override
  public Collection<IContract> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    ContractsResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IContract> result = new ArrayList<IContract>();
    result.addAll(response.getContracts());
    return result;
  }

}