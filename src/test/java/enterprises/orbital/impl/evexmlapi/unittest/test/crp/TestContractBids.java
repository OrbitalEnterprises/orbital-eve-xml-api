package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.shared.IContractBid;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestContractBids extends ApiTestSetup {

  @Test
  public void testGetContractBids() throws IOException, ParseException, SAXException {
    // Retrieve response
    ICorporationAPI request = requestor.getCorporationAPIService(0, "na", 0L);
    Collection<IContractBid> response = request.requestContractBids();

    // Compute XML for comparison
    String testData = CorpContractBidsConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiEndpoint.CRP_CONTRACTS_BIDS_V1, testConnector.getLastRequestParams(), testData);
  }

}
