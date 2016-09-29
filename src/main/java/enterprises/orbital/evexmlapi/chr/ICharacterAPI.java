package enterprises.orbital.evexmlapi.chr;

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
import enterprises.orbital.evexmlapi.shared.ILocation;
import enterprises.orbital.evexmlapi.shared.IMarketOrder;
import enterprises.orbital.evexmlapi.shared.IStandingSet;
import enterprises.orbital.evexmlapi.shared.IWalletJournalEntry;
import enterprises.orbital.evexmlapi.shared.IWalletTransaction;

public interface ICharacterAPI extends IResponse {
  public IAccountBalance requestAccountBalance() throws IOException;

  public Collection<IAsset> requestAssets() throws IOException;

  public Collection<ICalendarEventAttendee> requestCalendarEventAttendees(
                                                                          long... eventID)
    throws IOException;

  public ICharacterSheet requestCharacterSheet() throws IOException;

  public Collection<IBookmarkFolder> requestBookmarks() throws IOException;

  public Collection<IBlueprint> requestBlueprints() throws IOException;

  public Collection<IChatChannel> requestChatChannels() throws IOException;

  public IPartialCharacterSheet requestClones() throws IOException;

  public IContactSet requestContacts() throws IOException;

  public Collection<IContactNotification> requestContactNotifications() throws IOException;

  public Collection<IContract> requestContracts() throws IOException;

  public Collection<IContractBid> requestContractBids() throws IOException;

  public Collection<IContractItem> requestContractItems(
                                                        long contractID)
    throws IOException;

  public IFacWarStats requestFacWarStats() throws IOException;

  public Collection<IIndustryJob> requestIndustryJobs() throws IOException;

  public Collection<IIndustryJob> requestIndustryJobsHistory() throws IOException;

  public Collection<IKill> requestKillMails() throws IOException;

  public Collection<IKill> requestKillMails(
                                            long beforeKillID)
    throws IOException;

  public Collection<ILocation> requestLocations(
                                                long... itemID)
    throws IOException;

  public Collection<IMailBody> requestMailBodies(
                                                 long... messageID)
    throws IOException;

  public Collection<IMailList> requestMailingLists() throws IOException;

  public Collection<IMailMessage> requestMailMessages() throws IOException;

  public Collection<IMarketOrder> requestMarketOrders() throws IOException;

  public IMarketOrder requestMarketOrder(
                                         long orderID)
    throws IOException;

  public Collection<ICharacterMedal> requestMedals() throws IOException;

  public Collection<INotification> requestNotifications() throws IOException;

  public Collection<INotificationText> requestNotificationTexts(
                                                                long... notificationID)
    throws IOException;

  public Collection<IPlanetaryColony> requestPlanetaryColonies() throws IOException;

  public Collection<IPlanetaryLink> requestPlanetaryLinks(
                                                          long planetID)
    throws IOException;

  public Collection<IPlanetaryPin> requestPlanetaryPins(
                                                        long planetID)
    throws IOException;

  public Collection<IPlanetaryRoute> requestPlanetaryRoutes(
                                                            long planetID)
    throws IOException;

  public Collection<IResearchAgent> requestResearchAgents() throws IOException;

  public ISkillInTraining requestSkillInTraining() throws IOException;

  public Collection<ISkillInQueue> requestSkillQueue() throws IOException;

  public ISkillInfo requestSkills() throws IOException;

  public IStandingSet requestStandings() throws IOException;

  public Collection<IUpcomingCalendarEvent> requestUpcomingCalendarEvents() throws IOException;

  public Collection<IWalletJournalEntry> requestWalletJournalEntries() throws IOException;

  public Collection<IWalletJournalEntry> requestWalletJournalEntries(
                                                                     long beforeRefID)
    throws IOException;

  public Collection<IWalletTransaction> requestWalletTransactions() throws IOException;

  public Collection<IWalletTransaction> requestWalletTransactions(
                                                                  long beforeTransID)
    throws IOException;
}
