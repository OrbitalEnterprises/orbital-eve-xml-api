package enterprises.orbital.impl.evexmlapi.unittest.test.svr;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.eve.IConquerableStation;
import enterprises.orbital.evexmlapi.eve.IEveAPI;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestConquerableStationList extends ApiTestSetup {

	@Test
	public void testGetConquerableStationList() throws IOException,
			ParseException, SAXException {
		// Retrieve response
		IEveAPI request = requestor.getEveAPIService();
		Collection<IConquerableStation> response = request
				.requestConquerableStations();

		// Compute XML for comparison
		String testData = EveConquerableStationListConverter.convert(request,
				response);

		// Perform test
		ApiTestConnector.testComparison(ApiTestConnector.EVE_CONQ_STATION_LIST_CTL,
				ApiTestConnector.EVE_CONQ_STATION_LIST_TST,
				ApiTestConnector.EVE_CONQ_STATION_LIST_OUT, testData);
	}

}
