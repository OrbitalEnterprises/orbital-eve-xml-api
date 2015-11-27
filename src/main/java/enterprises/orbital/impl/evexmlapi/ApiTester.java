package enterprises.orbital.impl.evexmlapi;

import java.io.IOException;

import enterprises.orbital.evexmlapi.EveXmlApiAdapter;
import enterprises.orbital.evexmlapi.IResponse;
import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.crp.ICorporationAPI;

/**
 * Simple command line tool for testing server API calls.
 */
public class ApiTester {

  /**
   * Usage: keyID vCode apiName(e.g. corpAccountBalance) optional_args...
   * 
   * The optional args depend on the api. In many cases the characterID is the first optional arg
   */
  public static void main(String[] args) throws IOException {
    int offset = 3;
    int keyID = Integer.valueOf(args[0]);
    String vCode = args[1];
    String call = args[2];
    Object result = null;
    IResponse forErrorHandling = null;

    EveXmlApiAdapter adapter = new EveXmlApiAdapter();
    adapter.startup();

    if (call.equals("serverStatus")) {
      System.out.println(adapter.getServerAPIService().requestServerStatus());
    } else if (call.equals("characterSheet")) {
      long characterID = Long.valueOf(args[offset++]);
      ICharacterAPI requester = adapter.getCharacterAPIService(keyID, vCode, characterID);
      forErrorHandling = requester;
      result = requester.requestCharacterSheet();
    } else if (call.equals("corporationSheet")) {
      long characterID = Long.valueOf(args[offset++]);
      ICorporationAPI requester = adapter.getCorporationAPIService(keyID, vCode, characterID);
      forErrorHandling = requester;
      result = requester.requestCorporationSheet();
    } else {
      System.out.println("Call \"" + call + "\" not supported!");
      System.exit(1);
    }

    if (result != null) {
      System.out.println(result);
    } else {
      System.out.println("ERROR!");
      System.out.println("EveAPIVersion = " + forErrorHandling.getEveAPIVersion());
      System.out.println("CurrentTime = " + forErrorHandling.getCurrentTime());
      System.out.println("CachedUntil = " + forErrorHandling.getCachedUntil());
      System.out.println("isError = " + forErrorHandling.isError());
      System.out.println("ErrorCode = " + forErrorHandling.getErrorCode());
      System.out.println("ErrorString = " + forErrorHandling.getErrorString());
      System.out.println("RetryAfterDate = " + forErrorHandling.getErrorRetryAfterDate());
    }

  }
}
