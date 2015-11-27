package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.crp.ITitle;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestTitles extends ApiTestSetup {

	@Test
	public void testGetTitles() throws IOException, ParseException,
			SAXException {
		// Retrieve response
		ICorporationAPI request = requestor.getCorporationAPIService(0,
				"na", 0L);
		Collection<ITitle> response = request.requestTitles();

		// Compute XML for comparison
		String testData = CorpTitlesConverter.convert(request, response);

		// Perform test
		ApiTestConnector.testComparison(ApiTestConnector.CORP_TITLES_CTL,
				ApiTestConnector.CORP_TITLES_TST, ApiTestConnector.CORP_TITLES_OUT,
				testData);
	}

}
