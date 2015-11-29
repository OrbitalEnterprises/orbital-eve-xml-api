package enterprises.orbital.impl.evexmlapi.unittest.test.eve;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.eve.IConquerableStation;
import enterprises.orbital.evexmlapi.eve.IEveAPI;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestConquerableStationList extends ApiTestSetup {

  @Test
  public void testGetConquerableStationList() throws IOException, ParseException, SAXException {
    // Retrieve response
    IEveAPI request = requestor.getEveAPIService();
    Collection<IConquerableStation> response = request.requestConquerableStations();

    // Compute XML for comparison
    String testData = EveConquerableStationListConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiEndpoint.EVE_CONQUERABLE_STATION_LIST_V2, testConnector.getLastRequestParams(), testData);
  }

}
