package enterprises.orbital.impl.evexmlapi.unittest.test.act;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.act.IAccountAPI;
import enterprises.orbital.evexmlapi.act.IAccountStatus;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestAccountStatus extends ApiTestSetup {

  @Test
  public void testGetAccountStatus() throws IOException, ParseException, SAXException {
    // Retrieve response
    IAccountAPI request = requestor.getAccountAPIService(0, "na");
    IAccountStatus response = request.requestAccountStatus();

    // Compute XML for comparison
    String testData = AcctAccountStatusConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiEndpoint.ACT_ACCOUNT_STATUS_V2, testConnector.getLastRequestParams(), testData);
  }

}
