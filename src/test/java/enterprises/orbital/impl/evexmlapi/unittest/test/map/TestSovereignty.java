package enterprises.orbital.impl.evexmlapi.unittest.test.map;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.map.IMapAPI;
import enterprises.orbital.evexmlapi.map.ISovereignty;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestSovereignty extends ApiTestSetup {

  @Test
  public void testGetSovereignty() throws IOException, ParseException, SAXException {
    // Retrieve response
    IMapAPI request = requestor.getMapAPIService();
    ISovereignty response = request.requestSovereignty();

    // Compute XML for comparison
    String testData = MapSovereigntyConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiEndpoint.MAP_SOVEREIGNTY_V1, testConnector.getLastRequestParams(), testData);
  }

}
