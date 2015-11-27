package enterprises.orbital.impl.evexmlapi.unittest.test.svr;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.map.IMapAPI;
import enterprises.orbital.evexmlapi.map.ISovereignty;
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
    ApiTestConnector.testComparison(ApiTestConnector.MAP_SOVEREIGNTY_CTL, ApiTestConnector.MAP_SOVEREIGNTY_TST, ApiTestConnector.MAP_SOVEREIGNTY_OUT, testData);
  }

}
