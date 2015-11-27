package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.shared.IBlueprint;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestBlueprintList extends ApiTestSetup {

  @Test
  public void testGetBlueprintList() throws IOException, ParseException, SAXException {
    // Retrieve response
    ICharacterAPI request = requestor.getCharacterAPIService(0, "na", 0L);
    Collection<IBlueprint> response = request.requestBlueprints();

    // Compute XML for comparison
    String testData = CharBlueprintsConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiTestConnector.CHAR_BLUEPRINTS_CTL, ApiTestConnector.CHAR_BLUEPRINTS_TST, ApiTestConnector.CHAR_BLUEPRINTS_OUT, testData);
  }

}
