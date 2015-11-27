package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.IPlanetaryLink;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestPlanetaryLinks extends ApiTestSetup {

  @Test
  public void testGetPlanetaryLinks() throws IOException, ParseException, SAXException {
    // Retrieve response
    ICharacterAPI request = requestor.getCharacterAPIService(0, "na", 0L);
    Collection<IPlanetaryLink> response = request.requestPlanetaryLinks(123L);

    // Compute XML for comparison
    String testData = CharPlanetaryLinksConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiTestConnector.CHAR_PLANETARY_LINKS_CTL, ApiTestConnector.CHAR_PLANETARY_LINKS_TST, ApiTestConnector.CHAR_PLANETARY_LINKS_OUT,
                                 testData);
  }

}
