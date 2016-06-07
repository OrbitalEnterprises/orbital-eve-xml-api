package enterprises.orbital.impl.evexmlapi.unittest.test.act;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.act.IAPIKeyInfo;
import enterprises.orbital.evexmlapi.act.IAccountAPI;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestAPIKeyInfo extends ApiTestSetup {

  @Test
  public void testGetAPIKeyInfo() throws IOException, ParseException, SAXException {
    // Retrieve response
    IAccountAPI request = requestor.getAccountAPIService(0, "na");
    IAPIKeyInfo response = request.requestAPIKeyInfo();

    // Compute XML for comparison
    String testData = AcctAPIKeyInfoConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiEndpoint.ACT_API_KEY_INFO_V1, testConnector.getLastRequestParams(), testData);
  }

}
