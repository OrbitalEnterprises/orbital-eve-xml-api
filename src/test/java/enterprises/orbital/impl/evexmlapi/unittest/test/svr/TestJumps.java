package enterprises.orbital.impl.evexmlapi.unittest.test.svr;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.map.IMapAPI;
import enterprises.orbital.evexmlapi.map.IMapJump;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestJumps extends ApiTestSetup {

	@Test
	public void testGetJumps() throws IOException, ParseException, SAXException {
		// Retrieve response
		IMapAPI request = requestor.getMapAPIService();
		IMapJump response = request.requestJumps();

		// Compute XML for comparison
		String testData = MapJumpsConverter.convert(request, response);

		// Perform test
		ApiTestConnector.testComparison(ApiTestConnector.MAP_JUMPS_CTL,
				ApiTestConnector.MAP_JUMPS_TST, ApiTestConnector.MAP_JUMPS_OUT,
				testData);
	}

}
