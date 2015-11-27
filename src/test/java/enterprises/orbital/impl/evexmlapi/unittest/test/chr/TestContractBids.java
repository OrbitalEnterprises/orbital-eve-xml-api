package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.shared.IContractBid;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestContractBids extends ApiTestSetup {

  @Test
  public void testGetContractBids() throws IOException, ParseException, SAXException {
    // Retrieve response
    ICharacterAPI request = requestor.getCharacterAPIService(0, "na", 0L);
    Collection<IContractBid> response = request.requestContractBids();

    // Compute XML for comparison
    String testData = CharContractBidsConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiTestConnector.CHAR_CONTRACT_BIDS_CTL, ApiTestConnector.CHAR_CONTRACT_BIDS_TST, ApiTestConnector.CHAR_CONTRACT_BIDS_OUT, testData);
  }

}
