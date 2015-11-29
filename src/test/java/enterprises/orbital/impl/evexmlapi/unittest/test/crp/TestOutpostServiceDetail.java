package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.crp.IOutpostServiceDetail;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestOutpostServiceDetail extends ApiTestSetup {

  @Test
  public void testGetOutpostServiceDetail() throws IOException, ParseException, SAXException {
    // Retrieve response
    ICorporationAPI request = requestor.getCorporationAPIService(0, "na", 0L);
    Collection<IOutpostServiceDetail> response = request.requestOutpostServiceDetail(0);

    // Compute XML for comparison
    String testData = CorpOutpostServiceDetailConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiEndpoint.CRP_OUTPOST_SERVICE_DETAIL_V2, testConnector.getLastRequestParams(), testData);
  }

}
