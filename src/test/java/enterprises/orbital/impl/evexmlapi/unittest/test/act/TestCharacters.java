package enterprises.orbital.impl.evexmlapi.unittest.test.act;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.act.IAccountAPI;
import enterprises.orbital.evexmlapi.act.ICharacter;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestCharacters extends ApiTestSetup {

  @Test
  public void testGetCharacters() throws IOException, ParseException, SAXException {
    // Retrieve response
    IAccountAPI request = requestor.getAccountAPIService(0, "na");
    Collection<ICharacter> response = request.requestCharacters();

    // Compute XML for comparison
    String testData = AcctCharactersConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiEndpoint.ACT_CHARACTERS_V1, testConnector.getLastRequestParams(), testData);
  }

}
