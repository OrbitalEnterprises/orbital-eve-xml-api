package enterprises.orbital.impl.evexmlapi.unittest.test.eve;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.eve.ICharacterAffiliation;
import enterprises.orbital.evexmlapi.eve.IEveAPI;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestCharacterAffiliation extends ApiTestSetup {

  @Test
  public void testGetCharacterAffiliation() throws IOException, ParseException, SAXException {
    // Retrieve response
    IEveAPI request = requestor.getEveAPIService();
    Collection<ICharacterAffiliation> response = request.requestCharacterAffiliation(92168909L, 1188435724L, 196379789L);

    // Compute XML for comparison
    String testData = EveCharacterAffiliationConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiEndpoint.EVE_CHARACTER_AFFILIATION_V2, testConnector.getLastRequestParams(), testData);
  }

}
