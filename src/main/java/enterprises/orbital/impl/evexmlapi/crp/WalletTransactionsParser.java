package enterprises.orbital.impl.evexmlapi.crp;

import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractWalletTransactionsParser;

public class WalletTransactionsParser extends AbstractWalletTransactionsParser {
  public WalletTransactionsParser(ApiConnector connector, int accountKey, Long beforeTransID) {
    super(connector, ApiEndpoint.CRP_WALLET_TRANSACTIONS_V2, accountKey, beforeTransID);
  }
}