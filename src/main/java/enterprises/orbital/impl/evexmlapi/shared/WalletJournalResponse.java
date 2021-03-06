package enterprises.orbital.impl.evexmlapi.shared;

import java.util.ArrayList;
import java.util.List;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class WalletJournalResponse extends ApiResponse {
  private final List<ApiJournalEntry> journalEntries = new ArrayList<ApiJournalEntry>();

  public void addJournalEntry(ApiJournalEntry entry) {
    journalEntries.add(entry);
  }

  public List<ApiJournalEntry> getJournalEntries() {
    return journalEntries;
  }
}