package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.IPlanetaryColony;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestPlanetaryColonies extends ApiTestSetup {

  @Test
  public void testGetPlanetaryColonies() throws IOException, ParseException, SAXException {
    // Retrieve response
    ICharacterAPI request = requestor.getCharacterAPIService(0, "na", 0L);
    Collection<IPlanetaryColony> response = request.requestPlanetaryColonies();

    // Compute XML for comparison
    String testData = CharPlanetaryColoniesConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiTestConnector.CHAR_PLANETARY_COLONIES_CTL, ApiTestConnector.CHAR_PLANETARY_COLONIES_TST,
                                 ApiTestConnector.CHAR_PLANETARY_COLONIES_OUT, testData);
  }

}
