package enterprises.orbital.impl.evexmlapi.unittest.test.map;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.map.IFacWarSystem;
import enterprises.orbital.evexmlapi.map.IMapAPI;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestFacWarSystems extends ApiTestSetup {

  @Test
  public void testGetFacWarSystems() throws IOException, ParseException, SAXException {
    // Retrieve response
    IMapAPI request = requestor.getMapAPIService();
    Collection<IFacWarSystem> response = request.requestFacWarSystems();

    // Compute XML for comparison
    String testData = MapFacWarSystemsConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiEndpoint.MAP_FAC_WAR_SYSTEMS_V2, testConnector.getLastRequestParams(), testData);
  }

}
