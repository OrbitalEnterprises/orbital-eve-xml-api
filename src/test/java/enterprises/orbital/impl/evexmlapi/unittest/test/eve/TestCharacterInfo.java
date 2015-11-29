package enterprises.orbital.impl.evexmlapi.unittest.test.eve;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.eve.ICharacterInfo;
import enterprises.orbital.evexmlapi.eve.IEveAPI;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestCharacterInfo extends ApiTestSetup {

  @Test
  public void testGetCharacterInfo() throws IOException, ParseException, SAXException {
    // Retrieve response
    IEveAPI request = requestor.getEveAPIService();
    ICharacterInfo response = request.requestCharacterInfo(0, "na", 0);

    // Compute XML for comparison
    String testData = EveCharacterInfoConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiEndpoint.EVE_CHARACTER_INFO_V2, testConnector.getLastRequestParams(), testData);
  }

}
