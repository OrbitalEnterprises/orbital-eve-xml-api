package enterprises.orbital.impl.evexmlapi;

/**
 * XML API Server endpoints.
 */
public enum ApiEndpoint {
                         // Account
                         ACT_ACCOUNT_STATUS_V2("/account/AccountStatus", 2),
                         ACT_API_KEY_INFO_V1("/account/APIKeyInfo", 1),
                         ACT_CHARACTERS_V1("/account/Characters", 1),

                         // API
                         API_CALL_LIST_V2("/API/CallList", 2),

                         // Character
                         CHR_ACCOUNT_BALANCE_V2("/char/AccountBalance", 2),
                         CHR_ASSET_LIST_V2("/char/AssetList", 2),
                         CHR_BLUEPRINTS_V2("/char/Blueprints", 2),
                         CHR_BOOKMARKS_V2("/char/Bookmarks", 2),
                         CHR_CALENDAR_EVENT_ATTENDEE_V2("/char/CalendarEventAttendees", 2),
                         CHR_CHARACTER_SHEET_V1("/char/CharacterSheet", 1),
                         CHR_CHAT_CHANNELS_V2("/char/ChatChannels", 2),
                         CHR_CLONES_V2("/char/Clones", 2),
                         CHR_CONTACT_LIST_V2("/char/ContactList", 2),
                         CHR_CONTACT_NOTIFICATIONS_V2("/char/ContactNotifications", 2),
                         CHR_CONTRACTS_BIDS_V1("/char/ContractBids", 1),
                         CHR_CONTRACTS_ITEMS_V1("/char/ContractItems", 1),
                         CHR_CONTRACTS_V1("/char/Contracts", 1),
                         CHR_FAC_WAR_STATS_V2("/char/FacWarStats", 2),
                         CHR_INDUSTRY_JOBS_HISTORY_V2("/char/IndustryJobsHistory", 2),
                         CHR_INDUSTRY_JOBS_V2("/char/IndustryJobs", 2),
                         CHR_KILL_MAILS_V2("/char/KillMails", 2),
                         CHR_LOCATIONS_V2("/char/Locations", 2),
                         CHR_MAIL_BODIES_V2("/char/MailBodies", 2),
                         CHR_MAIL_MESSAGES_V2("/char/MailMessages", 2),
                         CHR_MAILING_LISTS_V2("/char/MailingLists", 2),
                         CHR_MARKET_ORDERS_V2("/char/MarketOrders", 2),
                         CHR_MEDALS_V2("/char/Medals", 2),
                         CHR_NOTIFICATION_TEXTS_V2("/char/NotificationTexts", 2),
                         CHR_NOTIFICATIONS_V2("/char/Notifications", 2),
                         CHR_PLANETARY_COLONIES_V2("/char/PlanetaryColonies", 2),
                         CHR_PLANETARY_LINKS_V2("/char/PlanetaryLinks", 2),
                         CHR_PLANETARY_PINS_V2("/char/PlanetaryPins", 2),
                         CHR_PLANETARY_ROUTES_V2("/char/PlanetaryRoutes", 2),
                         CHR_RESEARCH_V2("/char/Research", 2),
                         CHR_SKILLS_V2("/char/Skills", 2),
                         CHR_SKILL_IN_TRAINING_V2("/char/SkillInTraining", 2),
                         CHR_SKILL_QUEUE_V2("/char/SkillQueue", 2),
                         CHR_STANDINGS_V2("/char/Standings", 2),
                         CHR_UPCOMING_CALENDAR_EVENTS_V2("/char/UpcomingCalendarEvents", 2),
                         CHR_WALLET_JOURNAL_V2("/char/WalletJournal", 2),
                         CHR_WALLET_TRANSACTIONS_V2("/char/WalletTransactions", 2),

                         // Corporation
                         CRP_ACCOUNT_BALANCE_V2("/corp/AccountBalance", 2),
                         CRP_ASSET_LIST_V2("/corp/AssetList", 2),
                         CRP_BLUEPRINTS_V2("/corp/Blueprints", 2),
                         CRP_BOOKMARKS_V2("/corp/Bookmarks", 2),
                         CRP_CONTACT_LIST_V2("/corp/ContactList", 2),
                         CRP_CONTAINER_LOG_V2("/corp/ContainerLog", 2),
                         CRP_CONTRACTS_BIDS_V1("/corp/ContractBids", 1),
                         CRP_CONTRACTS_ITEMS_V1("/corp/ContractItems", 1),
                         CRP_CONTRACTS_V1("/corp/Contracts", 1),
                         CRP_CORPORATION_SHEET_V2("/corp/CorporationSheet", 2),
                         CRP_CUSTOMS_OFFICES_V2("/corp/CustomsOffices", 2),
                         CRP_FAC_WAR_STATS_V2("/corp/FacWarStats", 2),
                         CRP_FACILITIES_V2("/corp/Facilities", 2),
                         CRP_INDUSTRY_JOBS_HISTORY_V2("/corp/IndustryJobsHistory", 2),
                         CRP_INDUSTRY_JOBS_V2("/corp/IndustryJobs", 2),
                         CRP_KILL_MAILS_V2("/corp/KillMails", 2),
                         CRP_LOCATIONS_V2("/corp/Locations", 2),
                         CRP_MARKET_ORDERS_V2("/corp/MarketOrders", 2),
                         CRP_MEDALS_V2("/corp/Medals", 2),
                         CRP_MEMBER_MEDALS_V2("/corp/MemberMedals", 2),
                         CRP_MEMBER_SECURITY_LOG_V2("/corp/MemberSecurityLog", 2),
                         CRP_MEMBER_SECURITY_V2("/corp/MemberSecurity", 2),
                         CRP_MEMBER_TRACKING_V2("/corp/MemberTracking", 2),
                         CRP_OUTPOST_LIST_V2("/corp/OutpostList", 2),
                         CRP_OUTPOST_SERVICE_DETAIL_V2("/corp/OutpostServiceDetail", 2),
                         CRP_SHAREHOLDERS_V2("/corp/Shareholders", 2),
                         CRP_STANDINGS_V2("/corp/Standings", 2),
                         CRP_STARBASE_DETAIL_V2("/corp/StarbaseDetail", 2),
                         CRP_STARBASE_LIST_V2("/corp/StarbaseList", 2),
                         CRP_TITLES_V2("/corp/Titles", 2),
                         CRP_WALLET_JOURNAL_V2("/corp/WalletJournal", 2),
                         CRP_WALLET_TRANSACTIONS_V2("/corp/WalletTransactions", 2),

                         // EVE
                         EVE_ALLIANCE_LIST_V2("/eve/AllianceList", 2),
                         EVE_CHARACTER_AFFILIATION_V2("/eve/CharacterAffiliation", 2),
                         EVE_CHARACTER_ID_V2("/eve/CharacterID", 2),
                         EVE_CHARACTER_INFO_V2("/eve/CharacterInfo", 2),
                         EVE_CHARACTER_NAME_V2("/eve/CharacterName", 2),
                         EVE_CONQUERABLE_STATION_LIST_V2("/eve/ConquerableStationList", 2),
                         EVE_ERROR_LIST_V2("/eve/ErrorList", 2),
                         EVE_FAC_WAR_STATS_V2("/eve/FacWarStats", 2),
                         EVE_FAC_WAR_TOP_STATS_V2("/eve/FacWarTopStats", 2),
                         EVE_REF_TYPES_V1("/eve/RefTypes", 1),
                         EVE_SKILL_TREE_V2("/eve/SkillTree", 2),
                         EVE_TYPE_NAME_V2("/eve/TypeName", 2),

                         // Map
                         MAP_FAC_WAR_SYSTEMS_V2("/map/FacWarSystems", 2),
                         MAP_JUMPS_V2("/map/Jumps", 2),
                         MAP_KILLS_V2("/map/Kills", 2),
                         MAP_SOVEREIGNTY_V1("/map/Sovereignty", 1),

                         // Server
                         SVR_SERVER_STATUS_V2("/server/ServerStatus", 2);

  private final String path;
  private final int    version;

  private ApiEndpoint(String path, int version) {
    this.path = path;
    this.version = version;
  }

  public String getFileName() {
    return path.replace('/', '_') + "_" + version;
  }

  public String getPath() {
    return path;
  }

  public int getVersion() {
    return version;
  }

  @Override
  public String toString() {
    return "Endpoint[path=" + path + ", version=" + version + "]";
  }
}
