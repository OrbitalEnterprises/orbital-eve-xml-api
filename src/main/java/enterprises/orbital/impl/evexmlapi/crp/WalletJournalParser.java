package enterprises.orbital.impl.evexmlapi.crp;

import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractWalletJournalParser;

public class WalletJournalParser extends AbstractWalletJournalParser {
  public WalletJournalParser(int accountKey, Long beforeRefID) {
    super(ApiEndpoint.CRP_WALLET_JOURNAL_V2, accountKey, beforeRefID);
  }
}