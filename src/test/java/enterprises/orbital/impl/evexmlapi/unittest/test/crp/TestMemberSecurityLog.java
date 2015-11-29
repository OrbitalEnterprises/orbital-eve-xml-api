package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.crp.IMemberSecurityLog;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestMemberSecurityLog extends ApiTestSetup {

  @Test
  public void testGetMemberSecurityLog() throws IOException, ParseException, SAXException {
    // Retrieve response
    ICorporationAPI request = requestor.getCorporationAPIService(0, "na", 0L);
    Collection<IMemberSecurityLog> response = request.requestMemberSecurityLog();

    // Compute XML for comparison
    String testData = CorpMemberSecurityLogConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiEndpoint.CRP_MEMBER_SECURITY_LOG_V2, testConnector.getLastRequestParams(), testData);
  }

}
