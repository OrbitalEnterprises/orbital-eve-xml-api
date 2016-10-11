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
import enterprises.orbital.evexmlapi.shared.ILocation;
import enterprises.orbital.evexmlapi.shared.IMarketOrder;
import enterprises.orbital.evexmlapi.shared.IStandingSet;
import enterprises.orbital.evexmlapi.shared.IWalletJournalEntry;
import enterprises.orbital.evexmlapi.shared.IWalletTransaction;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.ApiAuth;
import enterprises.orbital.impl.evexmlapi.ApiConnector;

public class CorporationAPIAdapter extends AbstractAPIRequestAdapter implements ICorporationAPI {

  public CorporationAPIAdapter(ApiConnector connector, int keyID, long characterID, String vCode) {
    super(connector);
    setAuth(new ApiAuth(keyID, characterID, vCode));
  }

  @Override
  public Collection<IAccountBalance> requestAccountBalances() throws IOException {
    return new AccountBalanceParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<IAsset> requestAssets() throws IOException {
    return requestAssets(false);
  }

  @Override
  public Collection<IAsset> requestAssets(
                                          boolean flat)
    throws IOException {
    return new AssetListParser(connector, flat).retrieveResponse(this);
  }

  @Override
  public Collection<IBlueprint> requestBlueprints() throws IOException {
    return new BlueprintsParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<IBookmarkFolder> requestBookmarks() throws IOException {
    return new BookmarksParser(connector).retrieveResponse(this);
  }

  @Override
  public IContactSet requestContacts() throws IOException {
    return new ContactListParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<IContainerLog> requestContainerLogs() throws IOException {
    return new ContainerLogParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<IContractBid> requestContractBids() throws IOException {
    return new ContractBidsParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<IContractItem> requestContractItems(
                                                        long contractID)
    throws IOException {
    return new ContractItemsParser(connector, contractID).retrieveResponse(this);
  }

  @Override
  public Collection<IContract> requestContracts() throws IOException {
    return new ContractsParser(connector).retrieveResponse(this);
  }

  @Override
  public ICorporationSheet requestCorporationSheet() throws IOException {
    return new CorporationSheetParser(connector, null).retrieveResponse(this);
  }

  @Override
  public ICorporationSheet requestCorporationSheet(
                                                   long corpID)
    throws IOException {
    return new CorporationSheetParser(connector, corpID).retrieveResponse(this);
  }

  @Override
  public Collection<ICustomsOffice> requestCustomsOffices() throws IOException {
    return new CustomsOfficeParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<IFacility> requestFacilities() throws IOException {
    return new FacilityParser(connector).retrieveResponse(this);
  }

  @Override
  public IFacWarStats requestFacWarStats() throws IOException {
    return new FacWarStatsParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<IIndustryJob> requestIndustryJobs() throws IOException {
    return new IndustryJobsParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<IIndustryJob> requestIndustryJobsHistory() throws IOException {
    return new IndustryJobsHistoryParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<IKill> requestKillMails() throws IOException {
    return new KillMailsParser(connector, null).retrieveResponse(this);
  }

  @Override
  public Collection<IKill> requestKillMails(
                                            long beforeKillID)
    throws IOException {
    return new KillMailsParser(connector, beforeKillID).retrieveResponse(this);
  }

  @Override
  public IMarketOrder requestMarketOrder(
                                         long orderID)
    throws IOException {
    Collection<IMarketOrder> result = new MarketOrdersParser(connector, orderID).retrieveResponse(this);
    if (result == null) return null;
    return result.isEmpty() ? null : result.iterator().next();
  }

  @Override
  public Collection<IMarketOrder> requestMarketOrders() throws IOException {
    return new MarketOrdersParser(connector, null).retrieveResponse(this);
  }

  @Override
  public Collection<ICorporationMedal> requestMedals() throws IOException {
    return new MedalsParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<IMemberMedal> requestMemberMedals() throws IOException {
    return new MemberMedalsParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<IMemberSecurity> requestMemberSecurity() throws IOException {
    return new MemberSecurityParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<IMemberSecurityLog> requestMemberSecurityLog() throws IOException {
    return new MemberSecurityLogParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<IMemberTracking> requestMemberTracking(
                                                           boolean extended)
    throws IOException {
    return new MemberTrackingParser(connector, extended).retrieveResponse(this);
  }

  @Override
  public Collection<IOutpost> requestOutpostList() throws IOException {
    return new OutpostListParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<IOutpostServiceDetail> requestOutpostServiceDetail(
                                                                       long itemID)
    throws IOException {
    return new OutpostServiceDetailParser(connector, itemID).retrieveResponse(this);
  }

  @Override
  public Collection<IShareholder> requestShareholders() throws IOException {
    return new ShareholdersParser(connector).retrieveResponse(this);
  }

  @Override
  public IStandingSet requestStandings() throws IOException {
    return new StandingsParser(connector).retrieveResponse(this);
  }

  @Override
  public IStarbaseDetail requestStarbaseDetail(
                                               long pos)
    throws IOException {
    return new StarbaseDetailParser(connector, pos).retrieveResponse(this);
  }

  @Override
  public Collection<IStarbase> requestStarbaseList() throws IOException {
    return new StarbaseListParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<ITitle> requestTitles() throws IOException {
    return new CorporationTitlesParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<IWalletJournalEntry> requestWalletJournalEntries(
                                                                     int account)
    throws IOException {
    return new WalletJournalParser(connector, account, null).retrieveResponse(this);
  }

  @Override
  public Collection<IWalletJournalEntry> requestWalletJournalEntries(
                                                                     int account,
                                                                     long beforeTransID)
    throws IOException {
    return new WalletJournalParser(connector, account, new Long(beforeTransID)).retrieveResponse(this);
  }

  @Override
  public Collection<IWalletTransaction> requestWalletTransactions(
                                                                  int account)
    throws IOException {
    return new WalletTransactionsParser(connector, account, null).retrieveResponse(this);
  }

  @Override
  public Collection<IWalletTransaction> requestWalletTransactions(
                                                                  int account,
                                                                  long beforeTransID)
    throws IOException {
    return new WalletTransactionsParser(connector, account, new Long(beforeTransID)).retrieveResponse(this);
  }

  @Override
  public Collection<ILocation> requestLocations(
                                                long... itemID)
    throws IOException {
    return new LocationsParser(connector, itemID).retrieveResponse(this);
  }

}
