package enterprises.orbital.impl.evexmlapi.chr;

import java.io.IOException;
import java.util.Collection;

import enterprises.orbital.evexmlapi.chr.ICalendarEventAttendee;
import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.ICharacterMedal;
import enterprises.orbital.evexmlapi.chr.ICharacterSheet;
import enterprises.orbital.evexmlapi.chr.IChatChannel;
import enterprises.orbital.evexmlapi.chr.IContactNotification;
import enterprises.orbital.evexmlapi.chr.IMailBody;
import enterprises.orbital.evexmlapi.chr.IMailList;
import enterprises.orbital.evexmlapi.chr.IMailMessage;
import enterprises.orbital.evexmlapi.chr.INotification;
import enterprises.orbital.evexmlapi.chr.INotificationText;
import enterprises.orbital.evexmlapi.chr.IPlanetaryColony;
import enterprises.orbital.evexmlapi.chr.IPlanetaryLink;
import enterprises.orbital.evexmlapi.chr.IPlanetaryPin;
import enterprises.orbital.evexmlapi.chr.IPlanetaryRoute;
import enterprises.orbital.evexmlapi.chr.IResearchAgent;
import enterprises.orbital.evexmlapi.chr.ISkillInQueue;
import enterprises.orbital.evexmlapi.chr.ISkillInTraining;
import enterprises.orbital.evexmlapi.chr.IUpcomingCalendarEvent;
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

public class CharacterAPIAdapter extends AbstractAPIRequestAdapter implements ICharacterAPI {

  public CharacterAPIAdapter(ApiConnector connector, int keyID, long characterID, String vCode) {
    super(connector);
    setAuth(new ApiAuth(keyID, characterID, vCode));
  }

  @Override
  public IAccountBalance requestAccountBalance() throws IOException {
    return new AccountBalanceParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<IAsset> requestAssets() throws IOException {
    return new AssetListParser(connector).retrieveResponse(this);
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
  public Collection<ICalendarEventAttendee> requestCalendarEventAttendees(int... eventID) throws IOException {
    return new CalendarEventAttendeeParser(connector, eventID).retrieveResponse(this);
  }

  @Override
  public ICharacterSheet requestCharacterSheet() throws IOException {
    return new CharacterSheetParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<IChatChannel> requestChatChannels() throws IOException {
    return new ChatChannelsParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<IContactNotification> requestContactNotifications() throws IOException {
    return new ContactNotificationsParser(connector).retrieveResponse(this);
  }

  @Override
  public IContactSet requestContacts() throws IOException {
    return new ContactListParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<IContractBid> requestContractBids() throws IOException {
    return new ContractBidsParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<IContractItem> requestContractItems(long contractID) throws IOException {
    return new ContractItemsParser(connector, contractID).retrieveResponse(this);
  }

  @Override
  public Collection<IContract> requestContracts() throws IOException {
    return new ContractsParser(connector).retrieveResponse(this);
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
  public Collection<IKill> requestKillMails(long beforeKillId) throws IOException {
    return new KillMailsParser(connector, beforeKillId).retrieveResponse(this);
  }

  @Override
  public Collection<IMailBody> requestMailBodies(long... messageID) throws IOException {
    return new MailBodiesParser(connector, messageID).retrieveResponse(this);
  }

  @Override
  public Collection<IMailList> requestMailingLists() throws IOException {
    return new MailingListsParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<IMailMessage> requestMailMessages() throws IOException {
    return new MailMessagesParser(connector).retrieveResponse(this);
  }

  @Override
  public IMarketOrder requestMarketOrder(long orderID) throws IOException {
    Collection<IMarketOrder> result = new MarketOrdersParser(connector, orderID).retrieveResponse(this);
    if (result == null) return null;
    return result.isEmpty() ? null : result.iterator().next();
  }

  @Override
  public Collection<IMarketOrder> requestMarketOrders() throws IOException {
    return new MarketOrdersParser(connector, null).retrieveResponse(this);
  }

  @Override
  public Collection<ICharacterMedal> requestMedals() throws IOException {
    return new MedalsParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<INotification> requestNotifications() throws IOException {
    return new NotificationsParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<INotificationText> requestNotificationTexts(long... notificationID) throws IOException {
    return new NotificationTextsParser(connector, notificationID).retrieveResponse(this);
  }

  @Override
  public Collection<IPlanetaryColony> requestPlanetaryColonies() throws IOException {
    return new PlanetaryColonyParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<IPlanetaryLink> requestPlanetaryLinks(long planetID) throws IOException {
    return new PlanetaryLinkParser(connector, planetID).retrieveResponse(this);
  }

  @Override
  public Collection<IPlanetaryPin> requestPlanetaryPins(long planetID) throws IOException {
    return new PlanetaryPinParser(connector, planetID).retrieveResponse(this);
  }

  @Override
  public Collection<IPlanetaryRoute> requestPlanetaryRoutes(long planetID) throws IOException {
    return new PlanetaryRouteParser(connector, planetID).retrieveResponse(this);
  }

  @Override
  public Collection<IResearchAgent> requestResearchAgents() throws IOException {
    return new ResearchParser(connector).retrieveResponse(this);
  }

  @Override
  public ISkillInTraining requestSkillInTraining() throws IOException {
    return new SkillInTrainingParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<ISkillInQueue> requestSkillQueue() throws IOException {
    return new SkillQueueParser(connector).retrieveResponse(this);
  }

  @Override
  public IStandingSet requestStandings() throws IOException {
    return new StandingsParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<IUpcomingCalendarEvent> requestUpcomingCalendarEvents() throws IOException {
    return new UpcomingCalendarEventsParser(connector).retrieveResponse(this);
  }

  @Override
  public Collection<IWalletJournalEntry> requestWalletJournalEntries() throws IOException {
    return new WalletJournalParser(connector, null).retrieveResponse(this);
  }

  @Override
  public Collection<IWalletJournalEntry> requestWalletJournalEntries(long beforeRefID) throws IOException {
    return new WalletJournalParser(connector, beforeRefID).retrieveResponse(this);
  }

  @Override
  public Collection<IWalletTransaction> requestWalletTransactions() throws IOException {
    return new WalletTransactionsParser(connector, null).retrieveResponse(this);
  }

  @Override
  public Collection<IWalletTransaction> requestWalletTransactions(long beforeTransID) throws IOException {
    return new WalletTransactionsParser(connector, beforeTransID).retrieveResponse(this);
  }

  @Override
  public Collection<ILocation> requestLocations(long... itemID) throws IOException {
    return new LocationsParser(connector, itemID).retrieveResponse(this);
  }
}
