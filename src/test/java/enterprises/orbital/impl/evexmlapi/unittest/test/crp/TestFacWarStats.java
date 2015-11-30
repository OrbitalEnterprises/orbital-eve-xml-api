package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Assert;
import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.shared.IFacWarStats;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestFacWarStats extends ApiTestSetup {

  @Test
  public void testGetFacWarStats() throws IOException, ParseException, SAXException {
    // Retrieve response
    ICorporationAPI request = requestor.getCorporationAPIService(0, "na", 0L);
    IFacWarStats response = request.requestFacWarStats();

    if (request.isError()) {
      Assert.fail("FacWarStats response is error, skipping test");
      return;
    }

    // Compute XML for comparison
    String testData = CorpFacWarStatsConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiEndpoint.CRP_FAC_WAR_STATS_V2, testConnector.getLastRequestParams(), testData);
  }

}
