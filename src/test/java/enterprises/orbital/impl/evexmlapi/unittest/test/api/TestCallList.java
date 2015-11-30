package enterprises.orbital.impl.evexmlapi.unittest.test.api;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.api.IApiAPI;
import enterprises.orbital.evexmlapi.api.ICallList;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestCallList extends ApiTestSetup {

  @Test
  public void testGetCallList() throws IOException, ParseException, SAXException {
    // Retrieve response
    IApiAPI request = requestor.getApiAPIService();
    ICallList response = request.requestCallList();

    // Compute XML for comparison
    String testData = CallListConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiEndpoint.API_CALL_LIST_V2, testConnector.getLastRequestParams(), testData);
  }

}
