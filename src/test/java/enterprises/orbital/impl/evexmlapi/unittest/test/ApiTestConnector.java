package enterprises.orbital.impl.evexmlapi.unittest.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.ElementNameAndAttributeQualifier;
import org.custommonkey.xmlunit.ElementQualifier;
import org.junit.Assert;
import org.xml.sax.SAXException;

import enterprises.orbital.impl.evexmlapi.ApiConnector;

public class ApiTestConnector extends ApiConnector {

  private static final Logger         _log                              = Logger.getLogger(ApiTestConnector.class.getName());
  private static Map<URI, String>     testSrcMap                        = new HashMap<URI, String>();
  protected static DifferenceListener textIgnorer;
  protected static ElementQualifier   elementChooser;

  // Constants defining URIs and test data
  public static final String          ACCT_CHARACTERS_URI               = "/account/Characters.xml.aspx";
  public static final String          ACCT_CHARACTERS_CTL               = "controldata/account/Characters.xml";
  public static final String          ACCT_CHARACTERS_TST               = "testdata/account/Characters.xml";
  public static final String          ACCT_CHARACTERS_OUT               = "testoutput/account/Characters.diff";

  public static final String          ACCT_ACCOUNT_STATUS_URI           = "/account/AccountStatus.xml.aspx";
  public static final String          ACCT_ACCOUNT_STATUS_CTL           = "controldata/account/AccountStatus.xml";
  public static final String          ACCT_ACCOUNT_STATUS_TST           = "testdata/account/AccountStatus.xml";
  public static final String          ACCT_ACCOUNT_STATUS_OUT           = "testoutput/account/AccountStatus.diff";

  public static final String          ACCT_API_KEY_INFO_URI             = "/account/APIKeyInfo.xml.aspx";
  public static final String          ACCT_API_KEY_INFO_CTL             = "controldata/account/APIKeyInfo.xml";
  public static final String          ACCT_API_KEY_INFO_TST             = "testdata/account/APIKeyInfo.xml";
  public static final String          ACCT_API_KEY_INFO_OUT             = "testoutput/account/APIKeyInfo.diff";

  public static final String          CHAR_ACCOUNT_BALANCE_URI          = "/char/AccountBalance.xml.aspx";
  public static final String          CHAR_ACCOUNT_BALANCE_CTL          = "controldata/char/AccountBalance.xml";
  public static final String          CHAR_ACCOUNT_BALANCE_TST          = "testdata/char/AccountBalance.xml";
  public static final String          CHAR_ACCOUNT_BALANCE_OUT          = "testoutput/char/AccountBalance.diff";

  public static final String          CHAR_ASSET_LIST_URI               = "/char/AssetList.xml.aspx";
  public static final String          CHAR_ASSET_LIST_CTL               = "controldata/char/AssetList.xml";
  public static final String          CHAR_ASSET_LIST_TST               = "testdata/char/AssetList.xml";
  public static final String          CHAR_ASSET_LIST_OUT               = "testoutput/char/AssetList.diff";

  public static final String          CHAR_BLUEPRINTS_URI               = "/char/Blueprints.xml.aspx";
  public static final String          CHAR_BLUEPRINTS_CTL               = "controldata/char/Blueprints.xml";
  public static final String          CHAR_BLUEPRINTS_TST               = "testdata/char/Blueprints.xml";
  public static final String          CHAR_BLUEPRINTS_OUT               = "testoutput/char/Blueprints.diff";

  public static final String          CHAR_BOOKMARKS_URI                = "/char/Bookmarks.xml.aspx";
  public static final String          CHAR_BOOKMARKS_CTL                = "controldata/char/Bookmarks.xml";
  public static final String          CHAR_BOOKMARKS_TST                = "testdata/char/Bookmarks.xml";
  public static final String          CHAR_BOOKMARKS_OUT                = "testoutput/char/Bookmarks.diff";

  public static final String          CHAR_CHATCHANNELS_URI             = "/char/ChatChannels.xml.aspx";
  public static final String          CHAR_CHATCHANNELS_CTL             = "controldata/char/ChatChannels.xml";
  public static final String          CHAR_CHATCHANNELS_TST             = "testdata/char/ChatChannels.xml";
  public static final String          CHAR_CHATCHANNELS_OUT             = "testoutput/char/ChatChannels.diff";

  public static final String          CHAR_CONTRACTS_URI                = "/char/Contracts.xml.aspx";
  public static final String          CHAR_CONTRACTS_CTL                = "controldata/char/Contracts.xml";
  public static final String          CHAR_CONTRACTS_TST                = "testdata/char/Contracts.xml";
  public static final String          CHAR_CONTRACTS_OUT                = "testoutput/char/Contracts.diff";

  public static final String          CHAR_CONTRACT_ITEMS_URI           = "/char/ContractItems.xml.aspx";
  public static final String          CHAR_CONTRACT_ITEMS_CTL           = "controldata/char/ContractItems.xml";
  public static final String          CHAR_CONTRACT_ITEMS_TST           = "testdata/char/ContractItems.xml";
  public static final String          CHAR_CONTRACT_ITEMS_OUT           = "testoutput/char/ContractItems.diff";

  public static final String          CHAR_CONTRACT_BIDS_URI            = "/char/ContractBids.xml.aspx";
  public static final String          CHAR_CONTRACT_BIDS_CTL            = "controldata/char/ContractBids.xml";
  public static final String          CHAR_CONTRACT_BIDS_TST            = "testdata/char/ContractBids.xml";
  public static final String          CHAR_CONTRACT_BIDS_OUT            = "testoutput/char/ContractBids.diff";

  public static final String          CHAR_MAIL_BODIES_URI              = "/char/MailBodies.xml.aspx";
  public static final String          CHAR_MAIL_BODIES_CTL              = "controldata/char/MailBodies.xml";
  public static final String          CHAR_MAIL_BODIES_TST              = "testdata/char/MailBodies.xml";
  public static final String          CHAR_MAIL_BODIES_OUT              = "testoutput/char/MailBodies.diff";

  public static final String          CHAR_PLANETARY_COLONIES_URI       = "/char/PlanetaryColonies.xml.aspx";
  public static final String          CHAR_PLANETARY_COLONIES_CTL       = "controldata/char/PlanetaryColonies.xml";
  public static final String          CHAR_PLANETARY_COLONIES_TST       = "testdata/char/PlanetaryColonies.xml";
  public static final String          CHAR_PLANETARY_COLONIES_OUT       = "testoutput/char/PlanetaryColonies.diff";

  public static final String          CHAR_PLANETARY_LINKS_URI          = "/char/PlanetaryLinks.xml.aspx";
  public static final String          CHAR_PLANETARY_LINKS_CTL          = "controldata/char/PlanetaryLinks.xml";
  public static final String          CHAR_PLANETARY_LINKS_TST          = "testdata/char/PlanetaryLinks.xml";
  public static final String          CHAR_PLANETARY_LINKS_OUT          = "testoutput/char/PlanetaryLinks.diff";

  public static final String          CHAR_PLANETARY_ROUTES_URI         = "/char/PlanetaryRoutes.xml.aspx";
  public static final String          CHAR_PLANETARY_ROUTES_CTL         = "controldata/char/PlanetaryRoutes.xml";
  public static final String          CHAR_PLANETARY_ROUTES_TST         = "testdata/char/PlanetaryRoutes.xml";
  public static final String          CHAR_PLANETARY_ROUTES_OUT         = "testoutput/char/PlanetaryRoutes.diff";

  public static final String          CHAR_PLANETARY_PINS_URI           = "/char/PlanetaryPins.xml.aspx";
  public static final String          CHAR_PLANETARY_PINS_CTL           = "controldata/char/PlanetaryPins.xml";
  public static final String          CHAR_PLANETARY_PINS_TST           = "testdata/char/PlanetaryPins.xml";
  public static final String          CHAR_PLANETARY_PINS_OUT           = "testoutput/char/PlanetaryPins.diff";

  public static final String          CHAR_STANDINGS_URI                = "/char/Standings.xml.aspx";
  public static final String          CHAR_STANDINGS_CTL                = "controldata/char/Standings.xml";
  public static final String          CHAR_STANDINGS_TST                = "testdata/char/Standings.xml";
  public static final String          CHAR_STANDINGS_OUT                = "testoutput/char/Standings.diff";

  public static final String          CHAR_KILLLOG_URI                  = "/char/KillMails.xml.aspx";
  public static final String          CHAR_KILLLOG_CTL                  = "controldata/char/KillMails.xml";
  public static final String          CHAR_KILLLOG_TST                  = "testdata/char/KillMails.xml";
  public static final String          CHAR_KILLLOG_OUT                  = "testoutput/char/KillMails.diff";

  public static final String          CHAR_INDUSTRY_JOBS_URI            = "/char/IndustryJobs.xml.aspx";
  public static final String          CHAR_INDUSTRY_JOBS_CTL            = "controldata/char/IndustryJobs.xml";
  public static final String          CHAR_INDUSTRY_JOBS_TST            = "testdata/char/IndustryJobs.xml";
  public static final String          CHAR_INDUSTRY_JOBS_OUT            = "testoutput/char/IndustryJobs.diff";

  public static final String          CHAR_INDUSTRY_JOBS_HISTORY_URI    = "/char/IndustryJobsHistory.xml.aspx";
  public static final String          CHAR_INDUSTRY_JOBS_HISTORY_CTL    = "controldata/char/IndustryJobsHistory.xml";
  public static final String          CHAR_INDUSTRY_JOBS_HISTORY_TST    = "testdata/char/IndustryJobsHistory.xml";
  public static final String          CHAR_INDUSTRY_JOBS_HISTORY_OUT    = "testoutput/char/IndustryJobsHistory.diff";

  public static final String          CHAR_CHARACTER_SHEET_URI          = "/char/CharacterSheet.xml.aspx";
  public static final String          CHAR_CHARACTER_SHEET_CTL          = "controldata/char/CharacterSheet.xml";
  public static final String          CHAR_CHARACTER_SHEET_TST          = "testdata/char/CharacterSheet.xml";
  public static final String          CHAR_CHARACTER_SHEET_OUT          = "testoutput/char/CharacterSheet.diff";

  public static final String          CHAR_UPCOMING_CALENDAR_EVENTS_URI = "/char/UpcomingCalendarEvents.xml.aspx";
  public static final String          CHAR_UPCOMING_CALENDAR_EVENTS_CTL = "controldata/char/UpcomingCalendarEvents.xml";
  public static final String          CHAR_UPCOMING_CALENDAR_EVENTS_TST = "testdata/char/UpcomingCalendarEvents.xml";
  public static final String          CHAR_UPCOMING_CALENDAR_EVENTS_OUT = "testoutput/char/UpcomingCalendarEvents.diff";

  public static final String          CHAR_CALENDAR_EVENT_ATTENDEES_URI = "/char/CalendarEventAttendees.xml.aspx";
  public static final String          CHAR_CALENDAR_EVENT_ATTENDEES_CTL = "controldata/char/CalendarEventAttendees.xml";
  public static final String          CHAR_CALENDAR_EVENT_ATTENDEES_TST = "testdata/char/CalendarEventAttendees.xml";
  public static final String          CHAR_CALENDAR_EVENT_ATTENDEES_OUT = "testoutput/char/CalendarEventAttendees.diff";

  public static final String          CHAR_CONTACT_LIST_URI             = "/char/ContactList.xml.aspx";
  public static final String          CHAR_CONTACT_LIST_CTL             = "controldata/char/ContactList.xml";
  public static final String          CHAR_CONTACT_LIST_TST             = "testdata/char/ContactList.xml";
  public static final String          CHAR_CONTACT_LIST_OUT             = "testoutput/char/ContactList.diff";

  public static final String          CHAR_CONTACT_NOTIFICATIONS_URI    = "/char/ContactNotifications.xml.aspx";
  public static final String          CHAR_CONTACT_NOTIFICATIONS_CTL    = "controldata/char/ContactNotifications.xml";
  public static final String          CHAR_CONTACT_NOTIFICATIONS_TST    = "testdata/char/ContactNotifications.xml";
  public static final String          CHAR_CONTACT_NOTIFICATIONS_OUT    = "testoutput/char/ContactNotifications.diff";

  public static final String          CHAR_FAC_WAR_STATS_URI            = "/char/FacWarStats.xml.aspx";
  public static final String          CHAR_FAC_WAR_STATS_CTL            = "controldata/char/FacWarStats.xml";
  public static final String          CHAR_FAC_WAR_STATS_TST            = "testdata/char/FacWarStats.xml";
  public static final String          CHAR_FAC_WAR_STATS_OUT            = "testoutput/char/FacWarStats.diff";

  public static final String          CHAR_MAILING_LISTS_URI            = "/char/MailingLists.xml.aspx";
  public static final String          CHAR_MAILING_LISTS_CTL            = "controldata/char/MailingLists.xml";
  public static final String          CHAR_MAILING_LISTS_TST            = "testdata/char/MailingLists.xml";
  public static final String          CHAR_MAILING_LISTS_OUT            = "testoutput/char/MailingLists.diff";

  public static final String          CHAR_MAIL_MESSAGES_URI            = "/char/MailMessages.xml.aspx";
  public static final String          CHAR_MAIL_MESSAGES_CTL            = "controldata/char/MailMessages.xml";
  public static final String          CHAR_MAIL_MESSAGES_TST            = "testdata/char/MailMessages.xml";
  public static final String          CHAR_MAIL_MESSAGES_OUT            = "testoutput/char/MailMessages.diff";

  public static final String          CHAR_MARKET_ORDERS_URI            = "/char/MarketOrders.xml.aspx";
  public static final String          CHAR_MARKET_ORDERS_CTL            = "controldata/char/MarketOrders.xml";
  public static final String          CHAR_MARKET_ORDERS_TST            = "testdata/char/MarketOrders.xml";
  public static final String          CHAR_MARKET_ORDERS_OUT            = "testoutput/char/MarketOrders.diff";

  public static final String          CHAR_MARKET_ORDERS_BYID_URI       = "/char/MarketOrdersByID.xml.aspx";
  public static final String          CHAR_MARKET_ORDERS_BYID_CTL       = "controldata/char/MarketOrdersByID.xml";
  public static final String          CHAR_MARKET_ORDERS_BYID_TST       = "testdata/char/MarketOrdersByID.xml";
  public static final String          CHAR_MARKET_ORDERS_BYID_OUT       = "testoutput/char/MarketOrdersByID.diff";

  public static final String          CHAR_MEDALS_URI                   = "/char/Medals.xml.aspx";
  public static final String          CHAR_MEDALS_CTL                   = "controldata/char/Medals.xml";
  public static final String          CHAR_MEDALS_TST                   = "testdata/char/Medals.xml";
  public static final String          CHAR_MEDALS_OUT                   = "testoutput/char/Medals.diff";

  public static final String          CHAR_NOTIFICATIONS_URI            = "/char/Notifications.xml.aspx";
  public static final String          CHAR_NOTIFICATIONS_CTL            = "controldata/char/Notifications.xml";
  public static final String          CHAR_NOTIFICATIONS_TST            = "testdata/char/Notifications.xml";
  public static final String          CHAR_NOTIFICATIONS_OUT            = "testoutput/char/Notifications.diff";

  public static final String          CHAR_NOTIFICATION_TEXTS_URI       = "/char/NotificationTexts.xml.aspx";
  public static final String          CHAR_NOTIFICATION_TEXTS_CTL       = "controldata/char/NotificationTexts.xml";
  public static final String          CHAR_NOTIFICATION_TEXTS_TST       = "testdata/char/NotificationTexts.xml";
  public static final String          CHAR_NOTIFICATION_TEXTS_OUT       = "testoutput/char/NotificationTexts.diff";

  public static final String          CHAR_RESEARCH_URI                 = "/char/Research.xml.aspx";
  public static final String          CHAR_RESEARCH_CTL                 = "controldata/char/Research.xml";
  public static final String          CHAR_RESEARCH_TST                 = "testdata/char/Research.xml";
  public static final String          CHAR_RESEARCH_OUT                 = "testoutput/char/Research.diff";

  public static final String          CHAR_SKILL_IN_TRAINING_URI        = "/char/SkillInTraining.xml.aspx";
  public static final String          CHAR_SKILL_IN_TRAINING_CTL        = "controldata/char/SkillInTraining.xml";
  public static final String          CHAR_SKILL_IN_TRAINING_TST        = "testdata/char/SkillInTraining.xml";
  public static final String          CHAR_SKILL_IN_TRAINING_OUT        = "testoutput/char/SkillInTraining.diff";

  public static final String          CHAR_SKILL_QUEUE_URI              = "/char/SkillQueue.xml.aspx";
  public static final String          CHAR_SKILL_QUEUE_CTL              = "controldata/char/SkillQueue.xml";
  public static final String          CHAR_SKILL_QUEUE_TST              = "testdata/char/SkillQueue.xml";
  public static final String          CHAR_SKILL_QUEUE_OUT              = "testoutput/char/SkillQueue.diff";

  public static final String          CHAR_WALLET_JOURNAL_URI           = "/char/WalletJournal.xml.aspx";
  public static final String          CHAR_WALLET_JOURNAL_CTL           = "controldata/char/WalletJournal.xml";
  public static final String          CHAR_WALLET_JOURNAL_TST           = "testdata/char/WalletJournal.xml";
  public static final String          CHAR_WALLET_JOURNAL_OUT           = "testoutput/char/WalletJournal.diff";

  public static final String          CHAR_WALLET_TRANSACTIONS_URI      = "/char/WalletTransactions.xml.aspx";
  public static final String          CHAR_WALLET_TRANSACTIONS_CTL      = "controldata/char/WalletTransactions.xml";
  public static final String          CHAR_WALLET_TRANSACTIONS_TST      = "testdata/char/WalletTransactions.xml";
  public static final String          CHAR_WALLET_TRANSACTIONS_OUT      = "testoutput/char/WalletTransactions.diff";

  public static final String          CORP_ACCOUNT_BALANCE_URI          = "/corp/AccountBalance.xml.aspx";
  public static final String          CORP_ACCOUNT_BALANCE_CTL          = "controldata/corp/AccountBalance.xml";
  public static final String          CORP_ACCOUNT_BALANCE_TST          = "testdata/corp/AccountBalance.xml";
  public static final String          CORP_ACCOUNT_BALANCE_OUT          = "testoutput/corp/AccountBalance.diff";

  public static final String          CORP_ASSET_LIST_URI               = "/corp/AssetList.xml.aspx";
  public static final String          CORP_ASSET_LIST_CTL               = "controldata/corp/AssetList.xml";
  public static final String          CORP_ASSET_LIST_TST               = "testdata/corp/AssetList.xml";
  public static final String          CORP_ASSET_LIST_OUT               = "testoutput/corp/AssetList.diff";

  public static final String          CORP_BLUEPRINTS_URI               = "/corp/Blueprints.xml.aspx";
  public static final String          CORP_BLUEPRINTS_CTL               = "controldata/corp/Blueprints.xml";
  public static final String          CORP_BLUEPRINTS_TST               = "testdata/corp/Blueprints.xml";
  public static final String          CORP_BLUEPRINTS_OUT               = "testoutput/corp/Blueprints.diff";

  public static final String          CORP_BOOKMARKS_URI                = "/corp/Bookmarks.xml.aspx";
  public static final String          CORP_BOOKMARKS_CTL                = "controldata/corp/Bookmarks.xml";
  public static final String          CORP_BOOKMARKS_TST                = "testdata/corp/Bookmarks.xml";
  public static final String          CORP_BOOKMARKS_OUT                = "testoutput/corp/Bookmarks.diff";

  public static final String          CORP_CONTRACTS_URI                = "/corp/Contracts.xml.aspx";
  public static final String          CORP_CONTRACTS_CTL                = "controldata/corp/Contracts.xml";
  public static final String          CORP_CONTRACTS_TST                = "testdata/corp/Contracts.xml";
  public static final String          CORP_CONTRACTS_OUT                = "testoutput/corp/Contracts.diff";

  public static final String          CORP_CONTRACT_ITEMS_URI           = "/corp/ContractItems.xml.aspx";
  public static final String          CORP_CONTRACT_ITEMS_CTL           = "controldata/corp/ContractItems.xml";
  public static final String          CORP_CONTRACT_ITEMS_TST           = "testdata/corp/ContractItems.xml";
  public static final String          CORP_CONTRACT_ITEMS_OUT           = "testoutput/corp/ContractItems.diff";

  public static final String          CORP_CONTRACT_BIDS_URI            = "/corp/ContractBids.xml.aspx";
  public static final String          CORP_CONTRACT_BIDS_CTL            = "controldata/corp/ContractBids.xml";
  public static final String          CORP_CONTRACT_BIDS_TST            = "testdata/corp/ContractBids.xml";
  public static final String          CORP_CONTRACT_BIDS_OUT            = "testoutput/corp/ContractBids.diff";

  public static final String          CORP_CUSTOMS_OFFICES_URI          = "/corp/CustomsOffices.xml.aspx";
  public static final String          CORP_CUSTOMS_OFFICES_CTL          = "controldata/corp/CustomsOffices.xml";
  public static final String          CORP_CUSTOMS_OFFICES_TST          = "testdata/corp/CustomsOffices.xml";
  public static final String          CORP_CUSTOMS_OFFICES_OUT          = "testoutput/corp/CustomsOffices.diff";

  public static final String          CORP_FACILITIES_URI               = "/corp/Facilities.xml.aspx";
  public static final String          CORP_FACILITIES_CTL               = "controldata/corp/Facilities.xml";
  public static final String          CORP_FACILITIES_TST               = "testdata/corp/Facilities.xml";
  public static final String          CORP_FACILITIES_OUT               = "testoutput/corp/Facilities.diff";

  public static final String          CORP_STANDINGS_URI                = "/corp/Standings.xml.aspx";
  public static final String          CORP_STANDINGS_CTL                = "controldata/corp/Standings.xml";
  public static final String          CORP_STANDINGS_TST                = "testdata/corp/Standings.xml";
  public static final String          CORP_STANDINGS_OUT                = "testoutput/corp/Standings.diff";

  public static final String          CORP_KILLLOG_URI                  = "/corp/KillMails.xml.aspx";
  public static final String          CORP_KILLLOG_CTL                  = "controldata/corp/KillMails.xml";
  public static final String          CORP_KILLLOG_TST                  = "testdata/corp/KillMails.xml";
  public static final String          CORP_KILLLOG_OUT                  = "testoutput/corp/KillMails.diff";

  public static final String          CORP_INDUSTRY_JOBS_URI            = "/corp/IndustryJobs.xml.aspx";
  public static final String          CORP_INDUSTRY_JOBS_CTL            = "controldata/corp/IndustryJobs.xml";
  public static final String          CORP_INDUSTRY_JOBS_TST            = "testdata/corp/IndustryJobs.xml";
  public static final String          CORP_INDUSTRY_JOBS_OUT            = "testoutput/corp/IndustryJobs.diff";

  public static final String          CORP_INDUSTRY_JOBS_HISTORY_URI    = "/corp/IndustryJobsHistory.xml.aspx";
  public static final String          CORP_INDUSTRY_JOBS_HISTORY_CTL    = "controldata/corp/IndustryJobsHistory.xml";
  public static final String          CORP_INDUSTRY_JOBS_HISTORY_TST    = "testdata/corp/IndustryJobsHistory.xml";
  public static final String          CORP_INDUSTRY_JOBS_HISTORY_OUT    = "testoutput/corp/IndustryJobsHistory.diff";

  public static final String          CORP_CORPORATION_SHEET_URI        = "/corp/CorporationSheet.xml.aspx";
  public static final String          CORP_CORPORATION_SHEET_CTL        = "controldata/corp/CorporationSheet.xml";
  public static final String          CORP_CORPORATION_SHEET_TST        = "testdata/corp/CorporationSheet.xml";
  public static final String          CORP_CORPORATION_SHEET_OUT        = "testoutput/corp/CorporationSheet.diff";

  public static final String          CORP_UPCOMING_CALENDAR_EVENTS_URI = "/corp/UpcomingCalendarEvents.xml.aspx";
  public static final String          CORP_UPCOMING_CALENDAR_EVENTS_CTL = "controldata/corp/UpcomingCalendarEvents.xml";
  public static final String          CORP_UPCOMING_CALENDAR_EVENTS_TST = "testdata/corp/UpcomingCalendarEvents.xml";
  public static final String          CORP_UPCOMING_CALENDAR_EVENTS_OUT = "testoutput/corp/UpcomingCalendarEvents.diff";

  public static final String          CORP_CONTACT_LIST_URI             = "/corp/ContactList.xml.aspx";
  public static final String          CORP_CONTACT_LIST_CTL             = "controldata/corp/ContactList.xml";
  public static final String          CORP_CONTACT_LIST_TST             = "testdata/corp/ContactList.xml";
  public static final String          CORP_CONTACT_LIST_OUT             = "testoutput/corp/ContactList.diff";

  public static final String          CORP_FAC_WAR_STATS_URI            = "/corp/FacWarStats.xml.aspx";
  public static final String          CORP_FAC_WAR_STATS_CTL            = "controldata/corp/FacWarStats.xml";
  public static final String          CORP_FAC_WAR_STATS_TST            = "testdata/corp/FacWarStats.xml";
  public static final String          CORP_FAC_WAR_STATS_OUT            = "testoutput/corp/FacWarStats.diff";

  public static final String          CORP_MARKET_ORDERS_URI            = "/corp/MarketOrders.xml.aspx";
  public static final String          CORP_MARKET_ORDERS_CTL            = "controldata/corp/MarketOrders.xml";
  public static final String          CORP_MARKET_ORDERS_TST            = "testdata/corp/MarketOrders.xml";
  public static final String          CORP_MARKET_ORDERS_OUT            = "testoutput/corp/MarketOrders.diff";

  public static final String          CORP_MARKET_ORDERS_BYID_URI       = "/corp/MarketOrdersByID.xml.aspx";
  public static final String          CORP_MARKET_ORDERS_BYID_CTL       = "controldata/corp/MarketOrdersByID.xml";
  public static final String          CORP_MARKET_ORDERS_BYID_TST       = "testdata/corp/MarketOrdersByID.xml";
  public static final String          CORP_MARKET_ORDERS_BYID_OUT       = "testoutput/corp/MarketOrdersByID.diff";

  public static final String          CORP_MEDALS_URI                   = "/corp/Medals.xml.aspx";
  public static final String          CORP_MEDALS_CTL                   = "controldata/corp/Medals.xml";
  public static final String          CORP_MEDALS_TST                   = "testdata/corp/Medals.xml";
  public static final String          CORP_MEDALS_OUT                   = "testoutput/corp/Medals.diff";

  public static final String          CORP_RESEARCH_URI                 = "/corp/Research.xml.aspx";
  public static final String          CORP_RESEARCH_CTL                 = "controldata/corp/Research.xml";
  public static final String          CORP_RESEARCH_TST                 = "testdata/corp/Research.xml";
  public static final String          CORP_RESEARCH_OUT                 = "testoutput/corp/Research.diff";

  public static final String          CORP_WALLET_JOURNAL_URI           = "/corp/WalletJournal.xml.aspx";
  public static final String          CORP_WALLET_JOURNAL_CTL           = "controldata/corp/WalletJournal.xml";
  public static final String          CORP_WALLET_JOURNAL_TST           = "testdata/corp/WalletJournal.xml";
  public static final String          CORP_WALLET_JOURNAL_OUT           = "testoutput/corp/WalletJournal.diff";

  public static final String          CORP_WALLET_TRANSACTIONS_URI      = "/corp/WalletTransactions.xml.aspx";
  public static final String          CORP_WALLET_TRANSACTIONS_CTL      = "controldata/corp/WalletTransactions.xml";
  public static final String          CORP_WALLET_TRANSACTIONS_TST      = "testdata/corp/WalletTransactions.xml";
  public static final String          CORP_WALLET_TRANSACTIONS_OUT      = "testoutput/corp/WalletTransactions.diff";

  public static final String          CORP_CONTAINER_LOG_URI            = "/corp/ContainerLog.xml.aspx";
  public static final String          CORP_CONTAINER_LOG_CTL            = "controldata/corp/ContainerLog.xml";
  public static final String          CORP_CONTAINER_LOG_TST            = "testdata/corp/ContainerLog.xml";
  public static final String          CORP_CONTAINER_LOG_OUT            = "testoutput/corp/ContainerLog.diff";

  public static final String          CORP_MEMBER_MEDALS_URI            = "/corp/MemberMedals.xml.aspx";
  public static final String          CORP_MEMBER_MEDALS_CTL            = "controldata/corp/MemberMedals.xml";
  public static final String          CORP_MEMBER_MEDALS_TST            = "testdata/corp/MemberMedals.xml";
  public static final String          CORP_MEMBER_MEDALS_OUT            = "testoutput/corp/MemberMedals.diff";

  public static final String          CORP_MEMBER_SECURITY_URI          = "/corp/MemberSecurity.xml.aspx";
  public static final String          CORP_MEMBER_SECURITY_CTL          = "controldata/corp/MemberSecurity.xml";
  public static final String          CORP_MEMBER_SECURITY_TST          = "testdata/corp/MemberSecurity.xml";
  public static final String          CORP_MEMBER_SECURITY_OUT          = "testoutput/corp/MemberSecurity.diff";

  public static final String          CORP_MEMBER_SECURITY_LOG_URI      = "/corp/MemberSecurityLog.xml.aspx";
  public static final String          CORP_MEMBER_SECURITY_LOG_CTL      = "controldata/corp/MemberSecurityLog.xml";
  public static final String          CORP_MEMBER_SECURITY_LOG_TST      = "testdata/corp/MemberSecurityLog.xml";
  public static final String          CORP_MEMBER_SECURITY_LOG_OUT      = "testoutput/corp/MemberSecurityLog.diff";

  public static final String          CORP_MEMBER_TRACKING_URI          = "/corp/MemberTracking.xml.aspx";
  public static final String          CORP_MEMBER_TRACKING_CTL          = "controldata/corp/MemberTracking.xml";
  public static final String          CORP_MEMBER_TRACKING_TST          = "testdata/corp/MemberTracking.xml";
  public static final String          CORP_MEMBER_TRACKING_OUT          = "testoutput/corp/MemberTracking.diff";

  public static final String          CORP_SHAREHOLDERS_URI             = "/corp/Shareholders.xml.aspx";
  public static final String          CORP_SHAREHOLDERS_CTL             = "controldata/corp/Shareholders.xml";
  public static final String          CORP_SHAREHOLDERS_TST             = "testdata/corp/Shareholders.xml";
  public static final String          CORP_SHAREHOLDERS_OUT             = "testoutput/corp/Shareholders.diff";

  public static final String          CORP_STARBASE_DETAIL_URI          = "/corp/StarbaseDetail.xml.aspx";
  public static final String          CORP_STARBASE_DETAIL_CTL          = "controldata/corp/StarbaseDetail.xml";
  public static final String          CORP_STARBASE_DETAIL_TST          = "testdata/corp/StarbaseDetail.xml";
  public static final String          CORP_STARBASE_DETAIL_OUT          = "testoutput/corp/StarbaseDetail.diff";

  public static final String          CORP_OUTPOST_LIST_URI             = "/corp/OutpostList.xml.aspx";
  public static final String          CORP_OUTPOST_LIST_CTL             = "controldata/corp/OutpostList.xml";
  public static final String          CORP_OUTPOST_LIST_TST             = "testdata/corp/OutpostList.xml";
  public static final String          CORP_OUTPOST_LIST_OUT             = "testoutput/corp/OutpostList.diff";

  public static final String          CORP_OUTPOST_SERVICEDETAIL_URI    = "/corp/OutpostServiceDetail.xml.aspx";
  public static final String          CORP_OUTPOST_SERVICEDETAIL_CTL    = "controldata/corp/OutpostServiceDetail.xml";
  public static final String          CORP_OUTPOST_SERVICEDETAIL_TST    = "testdata/corp/OutpostServiceDetail.xml";
  public static final String          CORP_OUTPOST_SERVICEDETAIL_OUT    = "testoutput/corp/OutpostServiceDetail.diff";

  public static final String          CORP_STARBASE_LIST_URI            = "/corp/StarbaseList.xml.aspx";
  public static final String          CORP_STARBASE_LIST_CTL            = "controldata/corp/StarbaseList.xml";
  public static final String          CORP_STARBASE_LIST_TST            = "testdata/corp/StarbaseList.xml";
  public static final String          CORP_STARBASE_LIST_OUT            = "testoutput/corp/StarbaseList.diff";

  public static final String          CORP_TITLES_URI                   = "/corp/Titles.xml.aspx";
  public static final String          CORP_TITLES_CTL                   = "controldata/corp/Titles.xml";
  public static final String          CORP_TITLES_TST                   = "testdata/corp/Titles.xml";
  public static final String          CORP_TITLES_OUT                   = "testoutput/corp/Titles.diff";

  public static final String          SERVER_STATUS_URI                 = "/server/ServerStatus.xml.aspx";
  public static final String          SERVER_STATUS_CTL                 = "controldata/server/ServerStatus.xml";
  public static final String          SERVER_STATUS_TST                 = "testdata/server/ServerStatus.xml";
  public static final String          SERVER_STATUS_OUT                 = "testoutput/server/ServerStatus.diff";

  public static final String          EVE_ALLIANCE_LIST_URI             = "/eve/AllianceList.xml.aspx";
  public static final String          EVE_ALLIANCE_LIST_CTL             = "controldata/server/AllianceList.xml";
  public static final String          EVE_ALLIANCE_LIST_TST             = "testdata/server/AllianceList.xml";
  public static final String          EVE_ALLIANCE_LIST_OUT             = "testoutput/server/AllianceList.diff";

  public static final String          EVE_CERTIFICATE_TREE_URI          = "/eve/CertificateTree.xml.aspx";
  public static final String          EVE_CERTIFICATE_TREE_CTL          = "controldata/server/CertificateTree.xml";
  public static final String          EVE_CERTIFICATE_TREE_TST          = "testdata/server/CertificateTree.xml";
  public static final String          EVE_CERTIFICATE_TREE_OUT          = "testoutput/server/CertificateTree.diff";

  public static final String          EVE_CONQ_STATION_LIST_URI         = "/eve/ConquerableStationList.xml.aspx";
  public static final String          EVE_CONQ_STATION_LIST_CTL         = "controldata/server/ConquerableStationList.xml";
  public static final String          EVE_CONQ_STATION_LIST_TST         = "testdata/server/ConquerableStationList.xml";
  public static final String          EVE_CONQ_STATION_LIST_OUT         = "testoutput/server/ConquerableStationList.diff";

  public static final String          EVE_ERROR_LIST_URI                = "/eve/ErrorList.xml.aspx";
  public static final String          EVE_ERROR_LIST_CTL                = "controldata/server/ErrorList.xml";
  public static final String          EVE_ERROR_LIST_TST                = "testdata/server/ErrorList.xml";
  public static final String          EVE_ERROR_LIST_OUT                = "testoutput/server/ErrorList.diff";

  public static final String          EVE_FAC_WAR_STATS_URI             = "/eve/FacWarStats.xml.aspx";
  public static final String          EVE_FAC_WAR_STATS_CTL             = "controldata/server/FacWarStats.xml";
  public static final String          EVE_FAC_WAR_STATS_TST             = "testdata/server/FacWarStats.xml";
  public static final String          EVE_FAC_WAR_STATS_OUT             = "testoutput/server/FacWarStats.diff";

  public static final String          EVE_FAC_WAR_TOP_STATS_URI         = "/eve/FacWarTopStats.xml.aspx";
  public static final String          EVE_FAC_WAR_TOP_STATS_CTL         = "controldata/server/FacWarTopStats.xml";
  public static final String          EVE_FAC_WAR_TOP_STATS_TST         = "testdata/server/FacWarTopStats.xml";
  public static final String          EVE_FAC_WAR_TOP_STATS_OUT         = "testoutput/server/FacWarTopStats.diff";

  public static final String          EVE_REF_TYPES_URI                 = "/eve/RefTypes.xml.aspx";
  public static final String          EVE_REF_TYPES_CTL                 = "controldata/server/RefTypes.xml";
  public static final String          EVE_REF_TYPES_TST                 = "testdata/server/RefTypes.xml";
  public static final String          EVE_REF_TYPES_OUT                 = "testoutput/server/RefTypes.diff";

  public static final String          EVE_SKILL_TREE_URI                = "/eve/SkillTree.xml.aspx";
  public static final String          EVE_SKILL_TREE_CTL                = "controldata/server/SkillTree.xml";
  public static final String          EVE_SKILL_TREE_TST                = "testdata/server/SkillTree.xml";
  public static final String          EVE_SKILL_TREE_OUT                = "testoutput/server/SkillTree.diff";

  public static final String          EVE_CHARACTER_ID_URI              = "/eve/CharacterID.xml.aspx";
  public static final String          EVE_CHARACTER_ID_CTL              = "controldata/server/CharacterID.xml";
  public static final String          EVE_CHARACTER_ID_TST              = "testdata/server/CharacterID.xml";
  public static final String          EVE_CHARACTER_ID_OUT              = "testoutput/server/CharacterID.diff";

  public static final String          EVE_CHARACTER_INFO_URI            = "/eve/CharacterInfo.xml.aspx";
  public static final String          EVE_CHARACTER_INFO_CTL            = "controldata/server/CharacterInfo.xml";
  public static final String          EVE_CHARACTER_INFO_TST            = "testdata/server/CharacterInfo.xml";
  public static final String          EVE_CHARACTER_INFO_OUT            = "testoutput/server/CharacterInfo.diff";

  public static final String          EVE_CHARACTER_NAME_URI            = "/eve/CharacterName.xml.aspx";
  public static final String          EVE_CHARACTER_NAME_CTL            = "controldata/server/CharacterName.xml";
  public static final String          EVE_CHARACTER_NAME_TST            = "testdata/server/CharacterName.xml";
  public static final String          EVE_CHARACTER_NAME_OUT            = "testoutput/server/CharacterName.diff";

  public static final String          MAP_FAC_WAR_SYSTEMS_URI           = "/map/FacWarSystems.xml.aspx";
  public static final String          MAP_FAC_WAR_SYSTEMS_CTL           = "controldata/server/FacWarSystems.xml";
  public static final String          MAP_FAC_WAR_SYSTEMS_TST           = "testdata/server/FacWarSystems.xml";
  public static final String          MAP_FAC_WAR_SYSTEMS_OUT           = "testoutput/server/FacWarSystems.diff";

  public static final String          MAP_JUMPS_URI                     = "/map/Jumps.xml.aspx";
  public static final String          MAP_JUMPS_CTL                     = "controldata/server/Jumps.xml";
  public static final String          MAP_JUMPS_TST                     = "testdata/server/Jumps.xml";
  public static final String          MAP_JUMPS_OUT                     = "testoutput/server/Jumps.diff";

  public static final String          MAP_KILLS_URI                     = "/map/Kills.xml.aspx";
  public static final String          MAP_KILLS_CTL                     = "controldata/server/Kills.xml";
  public static final String          MAP_KILLS_TST                     = "testdata/server/Kills.xml";
  public static final String          MAP_KILLS_OUT                     = "testoutput/server/Kills.diff";

  public static final String          MAP_SOVEREIGNTY_URI               = "/map/Sovereignty.xml.aspx";
  public static final String          MAP_SOVEREIGNTY_CTL               = "controldata/server/Sovereignty.xml";
  public static final String          MAP_SOVEREIGNTY_TST               = "testdata/server/Sovereignty.xml";
  public static final String          MAP_SOVEREIGNTY_OUT               = "testoutput/server/Sovereignty.diff";

  private static final String[][]     testPairs                         = new String[][] {
                                                                            {
                                                                                ACCT_ACCOUNT_STATUS_URI, ACCT_ACCOUNT_STATUS_CTL
                                                                              },
                                                                            {
                                                                                ACCT_CHARACTERS_URI, ACCT_CHARACTERS_CTL
                                                                              },
                                                                            {
                                                                                ACCT_API_KEY_INFO_URI, ACCT_API_KEY_INFO_CTL
                                                                              },

                                                                            {
                                                                                CHAR_ACCOUNT_BALANCE_URI, CHAR_ACCOUNT_BALANCE_CTL
                                                                              },
                                                                            {
                                                                                CHAR_ASSET_LIST_URI, CHAR_ASSET_LIST_CTL
                                                                              },
                                                                            {
                                                                                CHAR_BLUEPRINTS_URI, CHAR_BLUEPRINTS_CTL
                                                                              },
                                                                            {
                                                                                CHAR_BOOKMARKS_URI, CHAR_BOOKMARKS_CTL
                                                                              },
                                                                            {
                                                                                CHAR_CHATCHANNELS_URI, CHAR_CHATCHANNELS_CTL
                                                                              },
                                                                            {
                                                                                CHAR_CONTRACTS_URI, CHAR_CONTRACTS_CTL
                                                                              },
                                                                            {
                                                                                CHAR_CONTRACT_ITEMS_URI, CHAR_CONTRACT_ITEMS_CTL
                                                                              },
                                                                            {
                                                                                CHAR_CONTRACT_BIDS_URI, CHAR_CONTRACT_BIDS_CTL
                                                                              },
                                                                            {
                                                                                CHAR_MAIL_BODIES_URI, CHAR_MAIL_BODIES_CTL
                                                                              },
                                                                            {
                                                                                CHAR_STANDINGS_URI, CHAR_STANDINGS_CTL
                                                                              },
                                                                            {
                                                                                CHAR_KILLLOG_URI, CHAR_KILLLOG_CTL
                                                                              },
                                                                            {
                                                                                CHAR_INDUSTRY_JOBS_URI, CHAR_INDUSTRY_JOBS_CTL
                                                                              },
                                                                            {
                                                                                CHAR_INDUSTRY_JOBS_HISTORY_URI, CHAR_INDUSTRY_JOBS_HISTORY_CTL
                                                                              },
                                                                            {
                                                                                CHAR_CHARACTER_SHEET_URI, CHAR_CHARACTER_SHEET_CTL
                                                                              },
                                                                            {
                                                                                CHAR_UPCOMING_CALENDAR_EVENTS_URI, CHAR_UPCOMING_CALENDAR_EVENTS_CTL
                                                                              },
                                                                            {
                                                                                CHAR_CALENDAR_EVENT_ATTENDEES_URI, CHAR_CALENDAR_EVENT_ATTENDEES_CTL
                                                                              },
                                                                            {
                                                                                CHAR_CONTACT_LIST_URI, CHAR_CONTACT_LIST_CTL
                                                                              },
                                                                            {
                                                                                CHAR_CONTACT_NOTIFICATIONS_URI, CHAR_CONTACT_NOTIFICATIONS_CTL
                                                                              },
                                                                            {
                                                                                CHAR_FAC_WAR_STATS_URI, CHAR_FAC_WAR_STATS_CTL
                                                                              },
                                                                            {
                                                                                CHAR_MAILING_LISTS_URI, CHAR_MAILING_LISTS_CTL
                                                                              },
                                                                            {
                                                                                CHAR_MAIL_MESSAGES_URI, CHAR_MAIL_MESSAGES_CTL
                                                                              },
                                                                            {
                                                                                CHAR_MARKET_ORDERS_URI, CHAR_MARKET_ORDERS_CTL
                                                                              },
                                                                            {
                                                                                CHAR_MARKET_ORDERS_BYID_URI, CHAR_MARKET_ORDERS_BYID_CTL
                                                                              },
                                                                            {
                                                                                CHAR_MEDALS_URI, CHAR_MEDALS_CTL
                                                                              },
                                                                            {
                                                                                CHAR_NOTIFICATIONS_URI, CHAR_NOTIFICATIONS_CTL
                                                                              },
                                                                            {
                                                                                CHAR_NOTIFICATION_TEXTS_URI, CHAR_NOTIFICATION_TEXTS_CTL
                                                                              },
                                                                            {
                                                                                CHAR_PLANETARY_COLONIES_URI, CHAR_PLANETARY_COLONIES_CTL
                                                                              },
                                                                            {
                                                                                CHAR_PLANETARY_LINKS_URI, CHAR_PLANETARY_LINKS_CTL
                                                                              },
                                                                            {
                                                                                CHAR_PLANETARY_ROUTES_URI, CHAR_PLANETARY_ROUTES_CTL
                                                                              },
                                                                            {
                                                                                CHAR_PLANETARY_PINS_URI, CHAR_PLANETARY_PINS_CTL
                                                                              },
                                                                            {
                                                                                CHAR_RESEARCH_URI, CHAR_RESEARCH_CTL
                                                                              },
                                                                            {
                                                                                CHAR_SKILL_IN_TRAINING_URI, CHAR_SKILL_IN_TRAINING_CTL
                                                                              },
                                                                            {
                                                                                CHAR_SKILL_QUEUE_URI, CHAR_SKILL_QUEUE_CTL
                                                                              },
                                                                            {
                                                                                CHAR_WALLET_JOURNAL_URI, CHAR_WALLET_JOURNAL_CTL
                                                                              },
                                                                            {
                                                                                CHAR_WALLET_TRANSACTIONS_URI, CHAR_WALLET_TRANSACTIONS_CTL
                                                                              },

                                                                            {
                                                                                CORP_ACCOUNT_BALANCE_URI, CORP_ACCOUNT_BALANCE_CTL
                                                                              },
                                                                            {
                                                                                CORP_ASSET_LIST_URI, CORP_ASSET_LIST_CTL
                                                                              },
                                                                            {
                                                                                CORP_BLUEPRINTS_URI, CORP_BLUEPRINTS_CTL
                                                                              },
                                                                            {
                                                                                CORP_BOOKMARKS_URI, CORP_BOOKMARKS_CTL
                                                                              },
                                                                            {
                                                                                CORP_CONTRACTS_URI, CORP_CONTRACTS_CTL
                                                                              },
                                                                            {
                                                                                CORP_CONTRACT_ITEMS_URI, CORP_CONTRACT_ITEMS_CTL
                                                                              },
                                                                            {
                                                                                CORP_CONTRACT_BIDS_URI, CORP_CONTRACT_BIDS_CTL
                                                                              },
                                                                            {
                                                                                CORP_STANDINGS_URI, CORP_STANDINGS_CTL
                                                                              },
                                                                            {
                                                                                CORP_KILLLOG_URI, CORP_KILLLOG_CTL
                                                                              },
                                                                            {
                                                                                CORP_INDUSTRY_JOBS_URI, CORP_INDUSTRY_JOBS_CTL
                                                                              },
                                                                            {
                                                                                CORP_INDUSTRY_JOBS_HISTORY_URI, CORP_INDUSTRY_JOBS_HISTORY_CTL
                                                                              },
                                                                            {
                                                                                CORP_CORPORATION_SHEET_URI, CORP_CORPORATION_SHEET_CTL
                                                                              },
                                                                            {
                                                                                CORP_CONTACT_LIST_URI, CORP_CONTACT_LIST_CTL
                                                                              },
                                                                            {
                                                                                CORP_FAC_WAR_STATS_URI, CORP_FAC_WAR_STATS_CTL
                                                                              },
                                                                            {
                                                                                CORP_MARKET_ORDERS_URI, CORP_MARKET_ORDERS_CTL
                                                                              },
                                                                            {
                                                                                CORP_MARKET_ORDERS_BYID_URI, CORP_MARKET_ORDERS_BYID_CTL
                                                                              },
                                                                            {
                                                                                CORP_CUSTOMS_OFFICES_URI, CORP_CUSTOMS_OFFICES_CTL
                                                                              },
                                                                            {
                                                                                CORP_FACILITIES_URI, CORP_FACILITIES_CTL
                                                                              },
                                                                            {
                                                                                CORP_MEDALS_URI, CORP_MEDALS_CTL
                                                                              },
                                                                            {
                                                                                CORP_WALLET_JOURNAL_URI, CORP_WALLET_JOURNAL_CTL
                                                                              },
                                                                            {
                                                                                CORP_WALLET_TRANSACTIONS_URI, CORP_WALLET_TRANSACTIONS_CTL
                                                                              },
                                                                            {
                                                                                CORP_CONTAINER_LOG_URI, CORP_CONTAINER_LOG_CTL
                                                                              },
                                                                            {
                                                                                CORP_MEMBER_MEDALS_URI, CORP_MEMBER_MEDALS_CTL
                                                                              },
                                                                            {
                                                                                CORP_MEMBER_SECURITY_URI, CORP_MEMBER_SECURITY_CTL
                                                                              },
                                                                            {
                                                                                CORP_MEMBER_SECURITY_LOG_URI, CORP_MEMBER_SECURITY_LOG_CTL
                                                                              },
                                                                            {
                                                                                CORP_MEMBER_TRACKING_URI, CORP_MEMBER_TRACKING_CTL
                                                                              },
                                                                            {
                                                                                CORP_SHAREHOLDERS_URI, CORP_SHAREHOLDERS_CTL
                                                                              },
                                                                            {
                                                                                CORP_STARBASE_DETAIL_URI, CORP_STARBASE_DETAIL_CTL
                                                                              },
                                                                            {
                                                                                CORP_STARBASE_LIST_URI, CORP_STARBASE_LIST_CTL
                                                                              },
                                                                            {
                                                                                CORP_OUTPOST_LIST_URI, CORP_OUTPOST_LIST_CTL
                                                                              },
                                                                            {
                                                                                CORP_OUTPOST_SERVICEDETAIL_URI, CORP_OUTPOST_SERVICEDETAIL_CTL
                                                                              },
                                                                            {
                                                                                CORP_TITLES_URI, CORP_TITLES_CTL
                                                                              },

                                                                            {
                                                                                SERVER_STATUS_URI, SERVER_STATUS_CTL
                                                                              },
                                                                            {
                                                                                EVE_ALLIANCE_LIST_URI, EVE_ALLIANCE_LIST_CTL
                                                                              },
                                                                            {
                                                                                EVE_CERTIFICATE_TREE_URI, EVE_CERTIFICATE_TREE_CTL
                                                                              },
                                                                            {
                                                                                EVE_CONQ_STATION_LIST_URI, EVE_CONQ_STATION_LIST_CTL
                                                                              },
                                                                            {
                                                                                EVE_ERROR_LIST_URI, EVE_ERROR_LIST_CTL
                                                                              },
                                                                            {
                                                                                EVE_FAC_WAR_STATS_URI, EVE_FAC_WAR_STATS_CTL
                                                                              },
                                                                            {
                                                                                EVE_FAC_WAR_TOP_STATS_URI, EVE_FAC_WAR_TOP_STATS_CTL
                                                                              },
                                                                            {
                                                                                EVE_REF_TYPES_URI, EVE_REF_TYPES_CTL
                                                                              },
                                                                            {
                                                                                EVE_SKILL_TREE_URI, EVE_SKILL_TREE_CTL
                                                                              },
                                                                            {
                                                                                EVE_CHARACTER_ID_URI, EVE_CHARACTER_ID_CTL
                                                                              },
                                                                            {
                                                                                EVE_CHARACTER_INFO_URI, EVE_CHARACTER_INFO_CTL
                                                                              },
                                                                            {
                                                                                EVE_CHARACTER_NAME_URI, EVE_CHARACTER_NAME_CTL
                                                                              },

                                                                            {
                                                                                MAP_FAC_WAR_SYSTEMS_URI, MAP_FAC_WAR_SYSTEMS_CTL
                                                                              },
                                                                            {
                                                                                MAP_JUMPS_URI, MAP_JUMPS_CTL
                                                                              },
                                                                            {
                                                                                MAP_KILLS_URI, MAP_KILLS_CTL
                                                                              },
                                                                            {
                                                                                MAP_SOVEREIGNTY_URI, MAP_SOVEREIGNTY_CTL
                                                                              },

                                                                          };

  static {
    textIgnorer = new EveApiDifferenceIgnorer();
    elementChooser = new ElementNameAndAttributeQualifier();

    try {
      // Load in test data
      for (String[] pair : testPairs) {
        testSrcMap.put(new URI("https://api.eveonline.com" + pair[0]), pair[1]);
      }
    } catch (Exception e) {
      e.printStackTrace();
      System.exit(1);
    }
  }

  @Override
  protected InputStream getInputStream(URI requestUri, Map<String, String> params) throws IOException {
    // Special case MarketOrder request when by orderid
    if (params.containsKey("orderid")) {
      // Switch to alternative URI if this is a market order
      try {
        URI checkCorpMarketOrder = new URI("https://api.eveonline.com" + CORP_MARKET_ORDERS_URI);
        if (requestUri.equals(checkCorpMarketOrder)) requestUri = new URI("https://api.eveonline.com" + CORP_MARKET_ORDERS_BYID_URI);
        URI checkCharMarketOrder = new URI("https://api.eveonline.com" + CHAR_MARKET_ORDERS_URI);
        if (requestUri.equals(checkCharMarketOrder)) requestUri = new URI("https://api.eveonline.com" + CHAR_MARKET_ORDERS_BYID_URI);
      } catch (URISyntaxException e) {
        // ignore
      }
    }
    // Return a stock response file based on the URL
    String source = testSrcMap.get(requestUri);

    if (source != null) {
      String altInputPath = System.getProperty("orbital.test.data.in");
      if (altInputPath != null)
        try {
          // This only gets set when we run unit tests from Eclipse JUnit
          // In that case, the resources won't be in the right place so we have
          // to use a FileInputStream instead.
          return new FileInputStream(altInputPath + source);
        } catch (FileNotFoundException e) {
          _log.log(Level.SEVERE, "Cant find file: " + altInputPath + source, e);
        }
      else {
        return ClassLoader.getSystemResourceAsStream(source);
      }
    }

    _log.severe("Can't find file for: " + requestUri);
    return null;
  }

  public static void storeTestData(String location, String data) throws IOException {
    File where = new File(System.getProperty("orbital.test.data.out") + location);
    if (!where.getParentFile().exists()) where.getParentFile().mkdirs();
    FileWriter output = new FileWriter(System.getProperty("orbital.test.data.out") + location);
    output.write(data);
    output.close();
  }

  public static String readTestData(String source) throws IOException {
    StringBuilder result = new StringBuilder();
    BufferedReader input = new BufferedReader(new FileReader(System.getProperty("orbital.test.data.in") + source));
    try {
      String next = input.readLine();

      while (next != null) {
        result.append(next).append('\n');
        next = input.readLine();
      }

      return result.toString();
    } finally {
      input.close();
    }
  }

  public static void testComparison(String controlLoc, String testLoc, String outputLoc, String testData) throws IOException, SAXException {
    storeTestData(testLoc, testData);
    String controlData = readTestData(controlLoc);

    // Test differences
    Diff xmlDiff = new Diff(controlData, testData);
    xmlDiff.overrideDifferenceListener(textIgnorer);
    xmlDiff.overrideElementQualifier(elementChooser);
    storeTestData(outputLoc, xmlDiff.toString());
    Assert.assertTrue(xmlDiff.similar());
  }

}
