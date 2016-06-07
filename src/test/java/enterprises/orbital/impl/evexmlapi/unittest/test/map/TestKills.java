package enterprises.orbital.impl.evexmlapi.unittest.test.map;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.map.IMapAPI;
import enterprises.orbital.evexmlapi.map.IMapKill;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestKills extends ApiTestSetup {

  @Test
  public void testGetKills() throws IOException, ParseException, SAXException {
    // Retrieve response
    IMapAPI request = requestor.getMapAPIService();
    IMapKill response = request.requestKills();

    // Compute XML for comparison
    String testData = MapKillsConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiEndpoint.MAP_KILLS_V2, testConnector.getLastRequestParams(), testData);
  }

}
