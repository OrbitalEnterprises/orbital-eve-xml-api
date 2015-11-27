package enterprises.orbital.impl.evexmlapi.shared;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.shared.IContractBid;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public abstract class AbstractContractBidsParser extends AbstractApiParser<ContractBidsResponse, Collection<IContractBid>> {
  public AbstractContractBidsParser(ApiEndpoint endpoint) {
    super(ContractBidsResponse.class, endpoint);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiContractBid.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addContractBid");
    return digester;
  }

  @Override
  public Collection<IContractBid> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    ContractBidsResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IContractBid> result = new ArrayList<IContractBid>();
    result.addAll(response.getContractBids());
    return result;
  }

}