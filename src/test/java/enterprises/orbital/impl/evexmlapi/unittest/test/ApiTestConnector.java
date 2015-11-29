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
import java.util.Arrays;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.digester.Digester;
import org.custommonkey.xmlunit.Diff;
import org.custommonkey.xmlunit.DifferenceListener;
import org.custommonkey.xmlunit.ElementNameAndAttributeQualifier;
import org.custommonkey.xmlunit.ElementQualifier;
import org.junit.Assert;
import org.xml.sax.SAXException;

import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.ApiRequest;
import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class ApiTestConnector extends ApiConnector {

  private static final Logger         _log           = Logger.getLogger(ApiTestConnector.class.getName());
  protected static DifferenceListener textIgnorer    = new EveApiDifferenceIgnorer();
  protected static ElementQualifier   elementChooser = new ElementNameAndAttributeQualifier();
  protected ApiRequest                lastRequest;

  public ApiTestConnector(URI uri, String object, int i, int j) {
    super(uri, object, i, j);
  }

  protected static String mapToSegment(Map<String, String> params) {
    if (params == null || params.isEmpty()) return "";
    StringBuilder builder = new StringBuilder("_");
    String[] keys = params.keySet().toArray(new String[0]);
    Arrays.sort(keys);
    for (int i = 0; i < keys.length; i++) {
      builder.append(keys[i]).append('=').append(params.get(keys[i])).append("_");
    }
    builder.setLength(builder.length() - 1);
    return builder.toString();
  }

  protected static ApiEndpoint mapURIToEndpoint(URI request) {
    for (ApiEndpoint next : ApiEndpoint.values()) {
      URI check = null;
      try {
        check = new URI("https://api.eveonline.com" + endpointToURI(next));
      } catch (URISyntaxException e) {
        // This should never happen!
        assert false;
      }
      if (check.equals(request)) return next;
    }
    return null;
  }

  protected static String endpointToURI(ApiEndpoint endpoint) {
    return endpoint.getPath() + ".xml.aspx";
  }

  protected static String endpointToControlData(ApiEndpoint endpoint, Map<String, String> params) {
    return "controldata" + endpoint.getPath() + mapToSegment(params) + ".xml";
  }

  protected static String endpointToTestData(ApiEndpoint endpoint, Map<String, String> params) {
    return "testdata" + endpoint.getPath() + mapToSegment(params) + ".xml";
  }

  protected static String endpointToTestOutput(ApiEndpoint endpoint, Map<String, String> params) {
    return "testoutput" + endpoint.getPath() + mapToSegment(params) + ".diff";
  }

  @Override
  protected InputStream getInputStream(URI requestUri, Map<String, String> params) throws IOException {
    ApiEndpoint target = mapURIToEndpoint(requestUri);
    assert target != null;

    // // Special case MarketOrder request when by orderid
    // if (params.containsKey("orderid")) {
    // // Switch to alternative URI if this is a market order
    // try {
    // URI checkCorpMarketOrder = new URI("https://api.eveonline.com" + CORP_MARKET_ORDERS_URI);
    // if (requestUri.equals(checkCorpMarketOrder)) requestUri = new URI("https://api.eveonline.com" + CORP_MARKET_ORDERS_BYID_URI);
    // URI checkCharMarketOrder = new URI("https://api.eveonline.com" + CHAR_MARKET_ORDERS_URI);
    // if (requestUri.equals(checkCharMarketOrder)) requestUri = new URI("https://api.eveonline.com" + CHAR_MARKET_ORDERS_BYID_URI);
    // } catch (URISyntaxException e) {
    // // ignore
    // }
    // }

    // Return a stock response file based on the URL
    // String source = testSrcMap.get(requestUri);
    String source = endpointToControlData(target, params);
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

  public static void testComparison(ApiEndpoint endpoint, Map<String, String> params, String testData) throws IOException, SAXException {
    storeTestData(endpointToTestData(endpoint, params), testData);
    String controlData = readTestData(endpointToControlData(endpoint, params));

    // Test differences
    Diff xmlDiff = new Diff(controlData, testData);
    xmlDiff.overrideDifferenceListener(textIgnorer);
    xmlDiff.overrideElementQualifier(elementChooser);
    storeTestData(endpointToTestOutput(endpoint, params), xmlDiff.toString());
    Assert.assertTrue(xmlDiff.similar());
  }

  @Override
  public <E extends ApiResponse> E execute(ApiRequest request, Digester digester, Class<E> clazz) throws IOException {
    // Trap last request for use by test code.
    lastRequest = request;
    return super.execute(request, digester, clazz);
  }

  public ApiRequest getLastRequest() {
    return lastRequest;
  }

  public Map<String, String> getLastRequestParams() {
    if (lastRequest == null) return null;
    return getParams(lastRequest);
  }
}
