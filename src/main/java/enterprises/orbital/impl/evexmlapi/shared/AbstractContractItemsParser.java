package enterprises.orbital.impl.evexmlapi.shared;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.shared.IContractItem;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiAuth;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public abstract class AbstractContractItemsParser extends AbstractApiParser<ContractItemsResponse, Collection<IContractItem>> {
  protected Long contractID;

  protected AbstractContractItemsParser(ApiConnector connector, ApiEndpoint endpoint, Long contractID) {
    super(connector, ContractItemsResponse.class, endpoint);
    this.contractID = contractID;
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiContractItem.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addContractItem");
    return digester;
  }

  protected ContractItemsResponse getResponseWithContractID(ApiAuth auth) throws IOException {
    if (contractID != null)
      return getResponse(auth, "contractID", String.valueOf(contractID));
    else
      return getResponse(auth);
  }

  @Override
  public Collection<IContractItem> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    ContractItemsResponse response = getResponseWithContractID(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IContractItem> result = new ArrayList<IContractItem>();
    result.addAll(response.getContractItems());
    return result;
  }

}