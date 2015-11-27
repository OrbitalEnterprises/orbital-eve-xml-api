package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractWalletJournalParser;

public class WalletJournalParser extends AbstractWalletJournalParser {
  public WalletJournalParser(Long beforeRefID) {
    super(ApiEndpoint.CHR_WALLET_JOURNAL_V2, 1000, beforeRefID);
  }
}