package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.IPlanetaryRoute;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestPlanetaryRoutes extends ApiTestSetup {

  @Test
  public void testGetPlanetaryRoutes() throws IOException, ParseException, SAXException {
    // Retrieve response
    ICharacterAPI request = requestor.getCharacterAPIService(0, "na", 0L);
    Collection<IPlanetaryRoute> response = request.requestPlanetaryRoutes(123L);

    // Compute XML for comparison
    String testData = CharPlanetaryRoutesConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiEndpoint.CHR_PLANETARY_ROUTES_V2, testConnector.getLastRequestParams(), testData);
  }

}
