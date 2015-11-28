package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractWalletJournalParser;

public class WalletJournalParser extends AbstractWalletJournalParser {
  public WalletJournalParser(ApiConnector connector, Long beforeRefID) {
    super(connector, ApiEndpoint.CHR_WALLET_JOURNAL_V2, 1000, beforeRefID);
  }
}