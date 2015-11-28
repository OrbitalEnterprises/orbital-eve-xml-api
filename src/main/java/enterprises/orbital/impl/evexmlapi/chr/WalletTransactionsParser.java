package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractWalletTransactionsParser;

public class WalletTransactionsParser extends AbstractWalletTransactionsParser {
  public WalletTransactionsParser(ApiConnector connector, Long beforeTransID) {
    super(connector, ApiEndpoint.CHR_WALLET_TRANSACTIONS_V2, 1000, beforeTransID);
  }
}