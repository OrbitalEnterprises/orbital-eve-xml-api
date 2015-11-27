package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractWalletTransactionsParser;

public class WalletTransactionsParser extends AbstractWalletTransactionsParser {
  public WalletTransactionsParser(Long beforeTransID) {
    super(ApiEndpoint.CHR_WALLET_TRANSACTIONS_V2, 1000, beforeTransID);
  }
}