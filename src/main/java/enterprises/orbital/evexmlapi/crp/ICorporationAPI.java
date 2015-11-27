package enterprises.orbital.evexmlapi.crp;

import java.io.IOException;
import java.util.Collection;

import enterprises.orbital.evexmlapi.IResponse;
import enterprises.orbital.evexmlapi.shared.IAccountBalance;
import enterprises.orbital.evexmlapi.shared.IAsset;
import enterprises.orbital.evexmlapi.shared.IBlueprint;
import enterprises.orbital.evexmlapi.shared.IBookmarkFolder;
import enterprises.orbital.evexmlapi.shared.IContactSet;
import enterprises.orbital.evexmlapi.shared.IContract;
import enterprises.orbital.evexmlapi.shared.IContractBid;
import enterprises.orbital.evexmlapi.shared.IContractItem;
import enterprises.orbital.evexmlapi.shared.IFacWarStats;
import enterprises.orbital.evexmlapi.shared.IIndustryJob;
import enterprises.orbital.evexmlapi.shared.IKill;
import enterprises.orbital.evexmlapi.shared.IMarketOrder;
import enterprises.orbital.evexmlapi.shared.IStandingSet;
import enterprises.orbital.evexmlapi.shared.IWalletJournalEntry;
import enterprises.orbital.evexmlapi.shared.IWalletTransaction;

public interface ICorporationAPI extends IResponse {
  public Collection<IAccountBalance> requestAccountBalances() throws IOException;

  public Collection<IAsset> requestAssets() throws IOException;

  public Collection<IBlueprint> requestBlueprints() throws IOException;

  public Collection<IBookmarkFolder> requestBookmarks() throws IOException;

  public IContactSet requestContacts() throws IOException;

  public Collection<IContainerLog> requestContainerLogs() throws IOException;

  public Collection<IContractBid> requestContractBids() throws IOException;

  public Collection<IContractItem> requestContractItems(long contractID) throws IOException;

  public Collection<IContract> requestContracts() throws IOException;

  public ICorporationSheet requestCorporationSheet() throws IOException;

  public ICorporationSheet requestCorporationSheet(long corpID) throws IOException;

  public Collection<ICustomsOffice> requestCustomsOffices() throws IOException;

  public Collection<IFacility> requestFacilities() throws IOException;

  public IFacWarStats requestFacWarStats() throws IOException;

  public Collection<IIndustryJob> requestIndustryJobs() throws IOException;

  public Collection<IIndustryJob> requestIndustryJobsHistory() throws IOException;

  public Collection<IKill> requestKillMails() throws IOException;

  public Collection<IKill> requestKillMails(long beforeKillID) throws IOException;

  public IMarketOrder requestMarketOrder(long orderID) throws IOException;

  public Collection<IMarketOrder> requestMarketOrders() throws IOException;

  public Collection<ICorporationMedal> requestMedals() throws IOException;

  public Collection<IMemberMedal> requestMemberMedals() throws IOException;

  public Collection<IMemberSecurity> requestMemberSecurity() throws IOException;

  public Collection<IMemberSecurityLog> requestMemberSecurityLog() throws IOException;

  public Collection<IMemberTracking> requestMemberTracking() throws IOException;

  public Collection<IOutpost> requestOutpostList() throws IOException;

  public Collection<IOutpostServiceDetail> requestOutpostServiceDetail(long itemID) throws IOException;

  public Collection<IShareholder> requestShareholders() throws IOException;

  public IStandingSet requestStandings() throws IOException;

  public IStarbaseDetail requestStarbaseDetail(long pos) throws IOException;

  public Collection<IStarbase> requestStarbaseList() throws IOException;

  public Collection<ITitle> requestTitles() throws IOException;

  public Collection<IWalletJournalEntry> requestWalletJournalEntries(int account) throws IOException;

  public Collection<IWalletJournalEntry> requestWalletJournalEntries(int account, long beforeTransID) throws IOException;

  public Collection<IWalletTransaction> requestWalletTransactions(int account) throws IOException;

  public Collection<IWalletTransaction> requestWalletTransactions(int account, long beforeTransID) throws IOException;
}
