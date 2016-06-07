package enterprises.orbital.impl.evexmlapi.unittest.test.svr;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.svr.IServerAPI;
import enterprises.orbital.evexmlapi.svr.IServerStatus;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestServerStatus extends ApiTestSetup {

  @Test
  public void testGetServerStatus() throws IOException, ParseException, SAXException {
    // Retrieve response
    IServerAPI request = requestor.getServerAPIService();
    IServerStatus response = request.requestServerStatus();

    // Compute XML for comparison
    String testData = ServerStatusConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiEndpoint.SVR_SERVER_STATUS_V2, testConnector.getLastRequestParams(), testData);
  }

}
