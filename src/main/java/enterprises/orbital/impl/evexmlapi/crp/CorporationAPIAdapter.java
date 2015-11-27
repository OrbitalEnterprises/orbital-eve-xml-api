package enterprises.orbital.impl.evexmlapi.crp;

import java.io.IOException;
import java.util.Collection;

import enterprises.orbital.evexmlapi.crp.IContainerLog;
import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.crp.ICorporationMedal;
import enterprises.orbital.evexmlapi.crp.ICorporationSheet;
import enterprises.orbital.evexmlapi.crp.ICustomsOffice;
import enterprises.orbital.evexmlapi.crp.IFacility;
import enterprises.orbital.evexmlapi.crp.IMemberMedal;
import enterprises.orbital.evexmlapi.crp.IMemberSecurity;
import enterprises.orbital.evexmlapi.crp.IMemberSecurityLog;
import enterprises.orbital.evexmlapi.crp.IMemberTracking;
import enterprises.orbital.evexmlapi.crp.IOutpost;
import enterprises.orbital.evexmlapi.crp.IOutpostServiceDetail;
import enterprises.orbital.evexmlapi.crp.IShareholder;
import enterprises.orbital.evexmlapi.crp.IStarbase;
import enterprises.orbital.evexmlapi.crp.IStarbaseDetail;
import enterprises.orbital.evexmlapi.crp.ITitle;
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
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.ApiAuth;

public class CorporationAPIAdapter extends AbstractAPIRequestAdapter implements ICorporationAPI {

  public CorporationAPIAdapter(int keyID, long characterID, String vCode) {
    setAuth(new ApiAuth(keyID, characterID, vCode));
  }

  @Override
  public Collection<IAccountBalance> requestAccountBalances() throws IOException {
    return new AccountBalanceParser().retrieveResponse(this);
  }

  @Override
  public Collection<IAsset> requestAssets() throws IOException {
    return new AssetListParser().retrieveResponse(this);
  }

  @Override
  public Collection<IBlueprint> requestBlueprints() throws IOException {
    return new BlueprintsParser().retrieveResponse(this);
  }

  @Override
  public Collection<IBookmarkFolder> requestBookmarks() throws IOException {
    return new BookmarksParser().retrieveResponse(this);
  }

  @Override
  public IContactSet requestContacts() throws IOException {
    return new ContactListParser().retrieveResponse(this);
  }

  @Override
  public Collection<IContainerLog> requestContainerLogs() throws IOException {
    return new ContainerLogParser().retrieveResponse(this);
  }

  @Override
  public Collection<IContractBid> requestContractBids() throws IOException {
    return new ContractBidsParser().retrieveResponse(this);
  }

  @Override
  public Collection<IContractItem> requestContractItems(long contractID) throws IOException {
    return new ContractItemsParser(contractID).retrieveResponse(this);
  }

  @Override
  public Collection<IContract> requestContracts() throws IOException {
    return new ContractsParser().retrieveResponse(this);
  }

  @Override
  public ICorporationSheet requestCorporationSheet() throws IOException {
    return new CorporationSheetParser(null).retrieveResponse(this);
  }

  @Override
  public ICorporationSheet requestCorporationSheet(long corpID) throws IOException {
    return new CorporationSheetParser(corpID).retrieveResponse(this);
  }

  @Override
  public Collection<ICustomsOffice> requestCustomsOffices() throws IOException {
    return new CustomsOfficeParser().retrieveResponse(this);
  }

  @Override
  public Collection<IFacility> requestFacilities() throws IOException {
    return new FacilityParser().retrieveResponse(this);
  }

  @Override
  public IFacWarStats requestFacWarStats() throws IOException {
    return new FacWarStatsParser().retrieveResponse(this);
  }

  @Override
  public Collection<IIndustryJob> requestIndustryJobs() throws IOException {
    return new IndustryJobsParser().retrieveResponse(this);
  }

  @Override
  public Collection<IIndustryJob> requestIndustryJobsHistory() throws IOException {
    return new IndustryJobsHistoryParser().retrieveResponse(this);
  }

  @Override
  public Collection<IKill> requestKillMails() throws IOException {
    return new KillMailsParser(null).retrieveResponse(this);
  }

  @Override
  public Collection<IKill> requestKillMails(long beforeKillID) throws IOException {
    return new KillMailsParser(beforeKillID).retrieveResponse(this);
  }

  @Override
  public IMarketOrder requestMarketOrder(long orderID) throws IOException {
    Collection<IMarketOrder> result = new MarketOrdersParser(orderID).retrieveResponse(this);
    if (result == null) return null;
    return result.isEmpty() ? null : result.iterator().next();
  }

  @Override
  public Collection<IMarketOrder> requestMarketOrders() throws IOException {
    return new MarketOrdersParser(null).retrieveResponse(this);
  }

  @Override
  public Collection<ICorporationMedal> requestMedals() throws IOException {
    return new MedalsParser().retrieveResponse(this);
  }

  @Override
  public Collection<IMemberMedal> requestMemberMedals() throws IOException {
    return new MemberMedalsParser().retrieveResponse(this);
  }

  @Override
  public Collection<IMemberSecurity> requestMemberSecurity() throws IOException {
    return new MemberSecurityParser().retrieveResponse(this);
  }

  @Override
  public Collection<IMemberSecurityLog> requestMemberSecurityLog() throws IOException {
    return new MemberSecurityLogParser().retrieveResponse(this);
  }

  @Override
  public Collection<IMemberTracking> requestMemberTracking() throws IOException {
    return new MemberTrackingParser().retrieveResponse(this);
  }

  @Override
  public Collection<IOutpost> requestOutpostList() throws IOException {
    return new OutpostListParser().retrieveResponse(this);
  }

  @Override
  public Collection<IOutpostServiceDetail> requestOutpostServiceDetail(long itemID) throws IOException {
    return new OutpostServiceDetailParser(itemID).retrieveResponse(this);
  }

  @Override
  public Collection<IShareholder> requestShareholders() throws IOException {
    return new ShareholdersParser().retrieveResponse(this);
  }

  @Override
  public IStandingSet requestStandings() throws IOException {
    return new StandingsParser().retrieveResponse(this);
  }

  @Override
  public IStarbaseDetail requestStarbaseDetail(long pos) throws IOException {
    return new StarbaseDetailParser(pos).retrieveResponse(this);
  }

  @Override
  public Collection<IStarbase> requestStarbaseList() throws IOException {
    return new StarbaseListParser().retrieveResponse(this);
  }

  @Override
  public Collection<ITitle> requestTitles() throws IOException {
    return new CorporationTitlesParser().retrieveResponse(this);
  }

  @Override
  public Collection<IWalletJournalEntry> requestWalletJournalEntries(int account) throws IOException {
    return new WalletJournalParser(account, null).retrieveResponse(this);
  }

  @Override
  public Collection<IWalletJournalEntry> requestWalletJournalEntries(int account, long beforeTransID) throws IOException {
    return new WalletJournalParser(account, new Long(beforeTransID)).retrieveResponse(this);
  }

  @Override
  public Collection<IWalletTransaction> requestWalletTransactions(int account) throws IOException {
    return new WalletTransactionsParser(account, null).retrieveResponse(this);
  }

  @Override
  public Collection<IWalletTransaction> requestWalletTransactions(int account, long beforeTransID) throws IOException {
    return new WalletTransactionsParser(account, new Long(beforeTransID)).retrieveResponse(this);
  }

}
