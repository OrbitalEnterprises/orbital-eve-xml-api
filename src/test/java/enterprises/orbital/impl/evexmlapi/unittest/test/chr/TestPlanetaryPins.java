package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.IPlanetaryPin;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestPlanetaryPins extends ApiTestSetup {

  @Test
  public void testGetPlanetaryPins() throws IOException, ParseException, SAXException {
    // Retrieve response
    ICharacterAPI request = requestor.getCharacterAPIService(0, "na", 0L);
    Collection<IPlanetaryPin> response = request.requestPlanetaryPins(123L);

    // Compute XML for comparison
    String testData = CharPlanetaryPinsConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiTestConnector.CHAR_PLANETARY_PINS_CTL, ApiTestConnector.CHAR_PLANETARY_PINS_TST, ApiTestConnector.CHAR_PLANETARY_PINS_OUT, testData);
  }

}
