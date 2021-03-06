package enterprises.orbital.impl.evexmlapi.unittest.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

/**
 * This class generates test data for the server API unit tests. We don't ship test data with the unit tests because it contains sensitive corp information. So
 * instead we provide a tool for generating test data yourself. We wouldn't have to do this if the various API web sites provided accurate test data but they
 * usually don't. The test data is generated by calling the EVE API directly and saving the resulting file as test data. The unit tests work by using the server
 * API to parse the response files, then traversing the resulting object to generate raw XML again. An XML diff tool then compares the two files and passes the
 * test if they are "similar", meaning they contain the same elements with the same contents but not necessarily in the same order.
 * 
 * To generate test data you need to specify a character keyID, a character vCode, a corporation keyID, a corporation vCode, and characterID to use for
 * character information queries, and a characterID to use for corporation queries. The results are stored in the "testdata" directory.
 */
public class GenerateTestData {

  protected static String       charKeyID      = null;
  protected static String       charVCode      = null;
  protected static String       charID         = null;
  protected static String       corpKeyID      = null;
  protected static String       corpVCode      = null;
  protected static String       corpID         = null;
  protected static String       fCharKeyID     = null;
  protected static String       fCharVCode     = null;
  protected static String       fCharID        = null;
  protected static List<String> nameLookupList = null;
  protected static List<Long>   idLookupList   = null;
  protected static String       serverURL      = "https://api.eveonline.com";

  protected static String usage() {
    StringBuilder help = new StringBuilder();
    help.append("java GenerateTestData -char keyID:vCode:ID -corp keyID:vCode:ID [-a] [-c] [-b] [-e] [-m] [-n names...] [-i ids...] [-fchar keyID:vCode:ID] [-u URL]\n");
    help.append("  -char <creds>    Character API credentials\n");
    help.append("  -corp <creds>    Corporation API credentials\n");
    help.append("  -a               Retrieve account level data\n");
    help.append("  -c               Retrieve character level data\n");
    help.append("  -b               Retrieve corporation level data\n");
    help.append("  -e               Retrieve Eve reference data\n");
    help.append("  -m               Retrieve map reference data\n");
    help.append("  -n               Comma separated list of names for ID lookup\n");
    help.append("  -i               Comma separated list of ids for name lookup\n");
    help.append("  -fchar <creds>   Optional FacWar credentials for character FacWar stats\n");
    help.append("  -u <url>         Set the EVE API server URL (defaults to https://api.eveonline.com)");

    return help.toString();
  }

  public static void main(String[] argv) throws Exception {
    boolean getAccountInfo = false;
    boolean getCharacterInfo = false;
    boolean getCorporationInfo = false;
    boolean getEveInfo = false;
    boolean getMapInfo = false;
    int i = 0;
    try {
      while (i < argv.length) {
        if (argv[i].equals("-a")) {
          getAccountInfo = true;
          i++;
        } else if (argv[i].equals("-n")) {
          nameLookupList = new ArrayList<String>();
          i++;
          nameLookupList.addAll(Arrays.asList(argv[i].split(",")));
          i++;
        } else if (argv[i].equals("-i")) {
          idLookupList = new ArrayList<Long>();
          i++;
          for (String id : argv[i].split(",")) {
            idLookupList.add(Long.valueOf(id));
          }
          i++;
        } else if (argv[i].equals("-c")) {
          getCharacterInfo = true;
          i++;
        } else if (argv[i].equals("-b")) {
          getCorporationInfo = true;
          i++;
        } else if (argv[i].equals("-e")) {
          getEveInfo = true;
          i++;
        } else if (argv[i].equals("-m")) {
          getMapInfo = true;
          i++;
        } else if (argv[i].equals("-char")) {
          i++;
          String[] args = argv[i].split(":");
          charKeyID = args[0];
          charVCode = args[1];
          charID = args[2];
          i++;
        } else if (argv[i].equals("-fchar")) {
          i++;
          String[] args = argv[i].split(":");
          fCharKeyID = args[0];
          fCharVCode = args[1];
          fCharID = args[2];
          i++;
        } else if (argv[i].equals("-corp")) {
          i++;
          String[] args = argv[i].split(":");
          corpKeyID = args[0];
          corpVCode = args[1];
          corpID = args[2];
          i++;
        } else if (argv[i].equals("-u")) {
          i++;
          serverURL = argv[i];
          i++;
        } else {
          System.err.println("Unrecognized argument: " + argv[i]);
          System.err.println(usage());
          System.exit(1);
        }
      }
    } catch (ArrayIndexOutOfBoundsException e) {
      System.err.println(usage());
      System.exit(1);
    }

    if (getAccountInfo) getAccountTestData();
    if (getCharacterInfo) getCharTestData();
    if (getCorporationInfo) getCorpTestData();
    if (getEveInfo) getEveTestData();
    if (getMapInfo) getMapTestData();

    System.exit(0);
  }

  protected static void storeTestData(String location, String data) throws IOException {
    FileWriter output = new FileWriter(location);
    output.write(data);
    output.close();
  }

  protected static String makeOutputFileName(ApiEndpoint endpoint, String... args) {
    String altInputPath = System.getProperty("orbital.test.data.in", "");
    String query = "";
    if (args.length == 1) {
      query += args[0];
    } else if (args.length > 1) {
      query += Arrays.toString(args).replace("[", "").replace(',', '&').replace(" ", "").replace("]", "");
    }
    Map<String, String> params = new HashMap<String, String>();
    if (args.length > 0) {
      for (String nextPair : query.split("&")) {
        String[] pair = nextPair.split("=");
        // Hide credentials in output file name
        switch (pair[0]) {
        case "characterID":
        case "keyID":
          pair[1] = "0";
          break;
        case "vCode":
          pair[1] = "na";
          break;
        default:
          break;
        }
        params.put(pair[0], pair[1]);
      }
    }
    return altInputPath + ApiTestConnector.endpointToControlData(endpoint, params);
  }

  protected static void retrieveAndStoreData(ApiEndpoint endpoint, String... args) throws IOException {
    String baseURL = serverURL + ApiTestConnector.endpointToURI(endpoint);
    String controlOutput = makeOutputFileName(endpoint, args);
    System.out.print("Retrieving " + baseURL + " to " + controlOutput + "...");

    String target = baseURL;
    if (args.length == 1) {
      target += '?' + args[0];
    } else if (args.length > 1) {
      target += Arrays.toString(args).replace('[', '?').replace(',', '&').replace(" ", "").replace("]", "");
    }

    // Skip if there already exists a file.
    File existingCheck = new File(controlOutput);
    if (existingCheck.exists() && existingCheck.isFile()) {
      System.out.println("skipped (exists)");
      return;
    }

    URL getter = new URL(target);
    BufferedReader dataIn = new BufferedReader(new InputStreamReader(getter.openStream()));
    String next = dataIn.readLine();
    StringBuilder result = new StringBuilder();
    while (next != null) {
      result.append(next).append('\n');
      next = dataIn.readLine();
    }
    dataIn.close();
    storeTestData(controlOutput, result.toString());
    System.out.println("done");
  }

  public static void getAccountTestData() throws IOException {
    String credentials = "keyID=" + charKeyID + "&vCode=" + charVCode;

    retrieveAndStoreData(ApiEndpoint.ACT_CHARACTERS_V1, credentials);
    retrieveAndStoreData(ApiEndpoint.ACT_ACCOUNT_STATUS_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.ACT_API_KEY_INFO_V1, credentials);
  }

  public static void getCharCalendarEventAttendees(String credentials) throws IOException {
    // Get CalendarEventAttendees. This only works if we have a recently
    // requested UpcomingCalendarEvents. Look at that file and pull out
    // all the event IDs to assemble a request.
    BufferedReader scanner = new BufferedReader(new FileReader(makeOutputFileName(ApiEndpoint.CHR_UPCOMING_CALENDAR_EVENTS_V2, credentials)));
    String nextLine = scanner.readLine();
    List<Long> ids = new ArrayList<Long>();
    Pattern matcher = Pattern.compile("eventID\\=\"([0-9]+)\"");
    while (nextLine != null) {
      Matcher check = matcher.matcher(nextLine);
      while (check.find()) {
        long nextID = Long.valueOf(check.group(1));
        ids.add(nextID);
      }
      nextLine = scanner.readLine();
    }

    String ceaCredentials = credentials + "&eventIDs=";
    for (Iterator<Long> adder = ids.iterator(); adder.hasNext();) {
      ceaCredentials += String.valueOf(adder.next());
      if (adder.hasNext()) ceaCredentials += ",";
    }

    retrieveAndStoreData(ApiEndpoint.CHR_CALENDAR_EVENT_ATTENDEE_V2, ceaCredentials);
    scanner.close();
  }

  public static void getEveNameLookup() throws IOException {
    String nameList = "names=";
    for (Iterator<String> adder = nameLookupList.iterator(); adder.hasNext();) {
      nameList += URLEncoder.encode(String.valueOf(adder.next()), "UTF-8");
      if (adder.hasNext()) nameList += ",";
    }

    retrieveAndStoreData(ApiEndpoint.EVE_CHARACTER_ID_V2, nameList);
  }

  public static void getEveIDLookup() throws IOException {
    String idList = "ids=";
    for (Iterator<Long> adder = idLookupList.iterator(); adder.hasNext();) {
      idList += String.valueOf(adder.next());
      if (adder.hasNext()) idList += ",";
    }

    retrieveAndStoreData(ApiEndpoint.EVE_CHARACTER_NAME_V2, idList);
  }

  public static void getCharMailBodies(String credentials) throws IOException {
    // Get MailBodies. This only works if we have recently requested MailMessages. Look at that file and pull out all message IDs to assemble a request.
    BufferedReader scanner = new BufferedReader(new FileReader(makeOutputFileName(ApiEndpoint.CHR_MAIL_MESSAGES_V2, credentials)));
    String nextLine = scanner.readLine();
    List<Long> ids = new ArrayList<Long>();
    Pattern matcher = Pattern.compile("messageID\\=\"([0-9]+)\"");
    while (nextLine != null) {
      Matcher check = matcher.matcher(nextLine);
      while (check.find()) {
        long nextID = Long.valueOf(check.group(1));
        ids.add(nextID);
      }
      nextLine = scanner.readLine();
    }

    String ceaCredentials = credentials + "&ids=";
    for (Iterator<Long> adder = ids.iterator(); adder.hasNext();) {
      ceaCredentials += String.valueOf(adder.next());
      if (adder.hasNext()) ceaCredentials += ",";
    }
    retrieveAndStoreData(ApiEndpoint.CHR_MAIL_BODIES_V2, ceaCredentials);
    scanner.close();
  }

  public static void getCharNotificationTexts(String credentials) throws IOException {
    // Get NotificationTexts. This only works if we have recently requested Notifications. Look at that file and pull out all notification IDs to assemble a
    // request.
    BufferedReader scanner = new BufferedReader(new FileReader(makeOutputFileName(ApiEndpoint.CHR_NOTIFICATIONS_V2, credentials)));
    String nextLine = scanner.readLine();
    List<Long> ids = new ArrayList<Long>();
    Pattern matcher = Pattern.compile("notificationID\\=\"([0-9]+)\"");
    while (nextLine != null) {
      Matcher check = matcher.matcher(nextLine);
      while (check.find()) {
        long nextID = Long.valueOf(check.group(1));
        ids.add(nextID);
      }
      nextLine = scanner.readLine();
    }

    String ceaCredentials = credentials + "&ids=";
    for (Iterator<Long> adder = ids.iterator(); adder.hasNext();) {
      ceaCredentials += String.valueOf(adder.next());
      if (adder.hasNext()) ceaCredentials += ",";
    }
    retrieveAndStoreData(ApiEndpoint.CHR_NOTIFICATION_TEXTS_V2, ceaCredentials);
    scanner.close();
  }

  public static void getCorpStarbaseDetail(String credentials) throws IOException {
    // Get StarbaseDetails. Requires a call to StarbaseList first in order to provide at least one itemID.
    BufferedReader scanner = new BufferedReader(new FileReader(makeOutputFileName(ApiEndpoint.CRP_STARBASE_LIST_V2, credentials)));
    String nextLine = scanner.readLine();
    List<Long> ids = new ArrayList<Long>();
    Pattern matcher = Pattern.compile("itemID\\=\"([0-9]+)\"");
    while (nextLine != null) {
      Matcher check = matcher.matcher(nextLine);
      while (check.find()) {
        long nextID = Long.valueOf(check.group(1));
        ids.add(nextID);
      }
      nextLine = scanner.readLine();
    }

    String ceaCredentials = credentials;
    if (ids.size() > 0) ceaCredentials += "&itemid=" + ids.get(0);
    retrieveAndStoreData(ApiEndpoint.CRP_STARBASE_DETAIL_V2, ceaCredentials);
    scanner.close();
  }

  public static void getCharContractItems(String credentials) throws IOException {
    // Get ContractItems. This only works if we have recently requested Contracts. Look at that file and pull out at least one contract ID to assemble a
    // request.
    BufferedReader scanner = new BufferedReader(new FileReader(makeOutputFileName(ApiEndpoint.CHR_CONTRACTS_V1, credentials)));
    String nextLine = scanner.readLine();
    List<Long> ids = new ArrayList<Long>();
    Pattern matcher = Pattern.compile("contractID\\=\"([0-9]+)\"");
    while (nextLine != null) {
      Matcher check = matcher.matcher(nextLine);
      while (check.find()) {
        long nextID = Long.valueOf(check.group(1));
        ids.add(nextID);
      }
      nextLine = scanner.readLine();
    }

    String ceaCredentials = credentials;
    if (ids.size() > 0) ceaCredentials += "&contractid=" + ids.get(0);
    retrieveAndStoreData(ApiEndpoint.CHR_CONTRACTS_ITEMS_V1, ceaCredentials);
    scanner.close();
  }

  public static void getCorpContractItems(String credentials) throws IOException {
    // Get ContractItems. This only works if we have recently requested Contracts. Look at that file and pull out at least one contract ID to assemble a
    // request.
    BufferedReader scanner = new BufferedReader(new FileReader(makeOutputFileName(ApiEndpoint.CRP_CONTRACTS_V1, credentials)));
    String nextLine = scanner.readLine();
    List<Long> ids = new ArrayList<Long>();
    Pattern matcher = Pattern.compile("contractID\\=\"([0-9]+)\"");
    while (nextLine != null) {
      Matcher check = matcher.matcher(nextLine);
      while (check.find()) {
        long nextID = Long.valueOf(check.group(1));
        ids.add(nextID);
      }
      nextLine = scanner.readLine();
    }

    String ceaCredentials = credentials;
    if (ids.size() > 0) ceaCredentials += "&contractid=" + ids.get(0);
    retrieveAndStoreData(ApiEndpoint.CRP_CONTRACTS_ITEMS_V1, ceaCredentials);
    scanner.close();
  }

  public static void getCharTestData() throws IOException {
    String credentials = "keyID=" + charKeyID + "&vCode=" + charVCode + "&characterID=" + charID;
    String fcredentials = fCharKeyID != null ? "keyID=" + fCharKeyID + "&vCode=" + fCharVCode + "&characterID=" + fCharID : null;

    retrieveAndStoreData(ApiEndpoint.CHR_ACCOUNT_BALANCE_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CHR_ASSET_LIST_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CHR_CONTRACTS_V1, credentials);
    getCharContractItems(credentials);
    retrieveAndStoreData(ApiEndpoint.CHR_CONTRACTS_BIDS_V1, credentials);
    retrieveAndStoreData(ApiEndpoint.CHR_INDUSTRY_JOBS_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CHR_INDUSTRY_JOBS_HISTORY_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CHR_KILL_MAILS_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CHR_STANDINGS_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CHR_CHARACTER_SHEET_V1, credentials);
    retrieveAndStoreData(ApiEndpoint.CHR_UPCOMING_CALENDAR_EVENTS_V2, credentials);
    getCharCalendarEventAttendees(credentials);
    retrieveAndStoreData(ApiEndpoint.CHR_CONTACT_LIST_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CHR_CONTACT_NOTIFICATIONS_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CHR_FAC_WAR_STATS_V2, fcredentials != null ? fcredentials : credentials);
    retrieveAndStoreData(ApiEndpoint.CHR_MAILING_LISTS_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CHR_MAIL_MESSAGES_V2, credentials);
    getCharMailBodies(credentials);
    retrieveAndStoreData(ApiEndpoint.CHR_MARKET_ORDERS_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CHR_MEDALS_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CHR_PLANETARY_COLONIES_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CHR_PLANETARY_LINKS_V2, credentials + "&planetID=40215544");
    retrieveAndStoreData(ApiEndpoint.CHR_PLANETARY_ROUTES_V2, credentials + "&planetID=40215544");
    retrieveAndStoreData(ApiEndpoint.CHR_PLANETARY_PINS_V2, credentials + "&planetID=40215544");
    retrieveAndStoreData(ApiEndpoint.CHR_NOTIFICATIONS_V2, credentials);
    getCharNotificationTexts(credentials);
    retrieveAndStoreData(ApiEndpoint.CHR_RESEARCH_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CHR_SKILL_IN_TRAINING_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CHR_SKILL_QUEUE_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CHR_WALLET_JOURNAL_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CHR_WALLET_TRANSACTIONS_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.EVE_CHARACTER_INFO_V2, credentials);
  }

  public static void getCorpTestData() throws IOException {
    String credentials = "keyID=" + corpKeyID + "&vCode=" + corpVCode + "&characterID=" + corpID;

    retrieveAndStoreData(ApiEndpoint.CRP_ACCOUNT_BALANCE_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CRP_ASSET_LIST_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CRP_CONTRACTS_V1, credentials);
    getCorpContractItems(credentials);
    retrieveAndStoreData(ApiEndpoint.CRP_CONTRACTS_BIDS_V1, credentials);
    retrieveAndStoreData(ApiEndpoint.CRP_INDUSTRY_JOBS_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CRP_INDUSTRY_JOBS_HISTORY_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CRP_KILL_MAILS_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CRP_STANDINGS_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CRP_CORPORATION_SHEET_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CRP_CONTACT_LIST_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CRP_FAC_WAR_STATS_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CRP_MARKET_ORDERS_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CRP_MEDALS_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CRP_WALLET_JOURNAL_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CRP_WALLET_TRANSACTIONS_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CRP_CONTAINER_LOG_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CRP_MEMBER_MEDALS_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CRP_MEMBER_SECURITY_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CRP_MEMBER_SECURITY_LOG_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CRP_MEMBER_TRACKING_V2, credentials + "&extended=1");
    retrieveAndStoreData(ApiEndpoint.CRP_SHAREHOLDERS_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CRP_STARBASE_LIST_V2, credentials);
    getCorpStarbaseDetail(credentials);
    retrieveAndStoreData(ApiEndpoint.CRP_TITLES_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CRP_FACILITIES_V2, credentials);
    retrieveAndStoreData(ApiEndpoint.CRP_CUSTOMS_OFFICES_V2, credentials);
  }

  public static void getEveTestData() throws IOException {
    retrieveAndStoreData(ApiEndpoint.SVR_SERVER_STATUS_V2);
    retrieveAndStoreData(ApiEndpoint.EVE_ALLIANCE_LIST_V2);
    retrieveAndStoreData(ApiEndpoint.EVE_CONQUERABLE_STATION_LIST_V2);
    retrieveAndStoreData(ApiEndpoint.EVE_ERROR_LIST_V2);
    retrieveAndStoreData(ApiEndpoint.EVE_FAC_WAR_STATS_V2);
    retrieveAndStoreData(ApiEndpoint.EVE_FAC_WAR_TOP_STATS_V2);
    retrieveAndStoreData(ApiEndpoint.EVE_REF_TYPES_V1);
    retrieveAndStoreData(ApiEndpoint.EVE_SKILL_TREE_V2);
    if (nameLookupList != null) getEveNameLookup();
    if (idLookupList != null) getEveIDLookup();
  }

  public static void getMapTestData() throws IOException {
    retrieveAndStoreData(ApiEndpoint.MAP_FAC_WAR_SYSTEMS_V2);
    retrieveAndStoreData(ApiEndpoint.MAP_JUMPS_V2);
    retrieveAndStoreData(ApiEndpoint.MAP_KILLS_V2);
    retrieveAndStoreData(ApiEndpoint.MAP_SOVEREIGNTY_V1);
  }

}
