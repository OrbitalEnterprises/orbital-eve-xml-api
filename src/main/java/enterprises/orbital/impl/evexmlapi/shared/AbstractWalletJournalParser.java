package enterprises.orbital.impl.evexmlapi.shared;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.digester.Digester;

import enterprises.orbital.base.PersistentProperty;
import enterprises.orbital.evexmlapi.shared.IWalletJournalEntry;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiAuth;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public abstract class AbstractWalletJournalParser extends AbstractApiParser<WalletJournalResponse, Collection<IWalletJournalEntry>> {
  public static final String WALLET_REQUEST_SIZE         = "enterprises.orbital.evexmlapi.walletRequestSize";
  public static final long   WALLET_REQUEST_SIZE_DEFAULT = 50L;

  protected int              accountKey;
  protected Long             beforeRefID;

  public AbstractWalletJournalParser(ApiConnector connector, ApiEndpoint endpoint, int accountKey, Long beforeRefID) {
    super(connector, WalletJournalResponse.class, endpoint);
    this.accountKey = accountKey;
    this.beforeRefID = beforeRefID;
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiJournalEntry.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addJournalEntry");
    return digester;
  }

  private WalletJournalResponse getResponseWithParams(ApiAuth auth) throws IOException {
    Map<String, String> extraParams = new HashMap<String, String>();
    extraParams.put("accountKey", Integer.toString(accountKey));
    if (beforeRefID != null) extraParams.put("fromID", Long.toString(beforeRefID));
    long rowCount = PersistentProperty.getLongPropertyWithFallback(WALLET_REQUEST_SIZE, WALLET_REQUEST_SIZE_DEFAULT);
    extraParams.put("rowCount", Long.toString(rowCount));
    return getResponse(auth, extraParams);
  }

  @Override
  public Collection<IWalletJournalEntry> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    WalletJournalResponse response = getResponseWithParams(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IWalletJournalEntry> result = new ArrayList<IWalletJournalEntry>();
    result.addAll(response.getJournalEntries());
    return result;
  }

}