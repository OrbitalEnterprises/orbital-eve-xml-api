package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.shared.IStandingSet;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestStandings extends ApiTestSetup {

  @Test
  public void testGetCharAssetList() throws IOException, ParseException, SAXException {
    // Retrieve response
    ICharacterAPI request = requestor.getCharacterAPIService(0, "na", 0L);
    IStandingSet response = request.requestStandings();

    // Compute XML for comparison
    String testData = CharStandingsConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiTestConnector.CHAR_STANDINGS_CTL, ApiTestConnector.CHAR_STANDINGS_TST, ApiTestConnector.CHAR_STANDINGS_OUT, testData);
  }

}
