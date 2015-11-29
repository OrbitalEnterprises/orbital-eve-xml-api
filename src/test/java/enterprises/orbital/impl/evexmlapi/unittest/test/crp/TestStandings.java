package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.shared.IStandingSet;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestStandings extends ApiTestSetup {

  @Test
  public void testGetStandings() throws IOException, ParseException, SAXException {
    // Retrieve response
    ICorporationAPI request = requestor.getCorporationAPIService(0, "na", 0L);
    IStandingSet response = request.requestStandings();

    // Compute XML for comparison
    String testData = CorpStandingsConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiEndpoint.CRP_STANDINGS_V2, testConnector.getLastRequestParams(), testData);
  }

}
