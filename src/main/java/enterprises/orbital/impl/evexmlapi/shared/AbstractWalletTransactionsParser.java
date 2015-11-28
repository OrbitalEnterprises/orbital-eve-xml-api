package enterprises.orbital.impl.evexmlapi.shared;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.digester.Digester;

import enterprises.orbital.base.PersistentProperty;
import enterprises.orbital.evexmlapi.shared.IWalletTransaction;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiAuth;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public abstract class AbstractWalletTransactionsParser extends AbstractApiParser<WalletTransactionsResponse, Collection<IWalletTransaction>> {
  protected int  accountKey;
  protected Long beforeTransID;

  public AbstractWalletTransactionsParser(ApiConnector connector, ApiEndpoint endpoint, int accountKey, Long beforeTransID) {
    super(connector, WalletTransactionsResponse.class, endpoint);
    this.accountKey = accountKey;
    this.beforeTransID = beforeTransID;
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiWalletTransaction.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addWalletTransaction");
    return digester;
  }

  private WalletTransactionsResponse getResponseWithParams(ApiAuth auth) throws IOException {
    Map<String, String> extraParams = new HashMap<String, String>();
    extraParams.put("accountKey", Integer.toString(accountKey));
    if (beforeTransID != null) extraParams.put("fromID", Long.toString(beforeTransID));
    long rowCount = PersistentProperty.getLongPropertyWithFallback(AbstractWalletJournalParser.WALLET_REQUEST_SIZE,
                                                                   AbstractWalletJournalParser.WALLET_REQUEST_SIZE_DEFAULT);
    extraParams.put("rowCount", Long.toString(rowCount));
    return getResponse(auth, extraParams);
  }

  @Override
  public Collection<IWalletTransaction> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    WalletTransactionsResponse response = getResponseWithParams(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IWalletTransaction> result = new ArrayList<IWalletTransaction>();
    result.addAll(response.getWalletTransactions());
    return result;
  }

}