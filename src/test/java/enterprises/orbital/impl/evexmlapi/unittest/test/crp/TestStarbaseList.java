package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.crp.IStarbase;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestStarbaseList extends ApiTestSetup {

	@Test
	public void testGetMedals() throws IOException, ParseException,
			SAXException {
		// Retrieve response
		ICorporationAPI request = requestor.getCorporationAPIService(0,
				"na", 0L);
		Collection<IStarbase> response = request.requestStarbaseList();

		// Compute XML for comparison
		String testData = CorpStarbaseListConverter.convert(request, response);

		// Perform test
		ApiTestConnector.testComparison(ApiTestConnector.CORP_STARBASE_LIST_CTL,
				ApiTestConnector.CORP_STARBASE_LIST_TST,
				ApiTestConnector.CORP_STARBASE_LIST_OUT, testData);
	}

}
