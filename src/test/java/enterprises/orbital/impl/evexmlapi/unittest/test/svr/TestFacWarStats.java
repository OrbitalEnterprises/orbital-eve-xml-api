package enterprises.orbital.impl.evexmlapi.unittest.test.svr;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.eve.IEveAPI;
import enterprises.orbital.evexmlapi.eve.IFacWarSummary;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestFacWarStats extends ApiTestSetup {

	@Test
	public void testGetFacWarStats() throws IOException, ParseException,
			SAXException {
		// Retrieve response
		IEveAPI request = requestor.getEveAPIService();
		IFacWarSummary response = request.requestFacWarStats();

		// Compute XML for comparison
		String testData = EveFacWarStatsConverter.convert(request, response);

		// Perform test
		ApiTestConnector.testComparison(ApiTestConnector.EVE_FAC_WAR_STATS_CTL,
				ApiTestConnector.EVE_FAC_WAR_STATS_TST,
				ApiTestConnector.EVE_FAC_WAR_STATS_OUT, testData);
	}

}
