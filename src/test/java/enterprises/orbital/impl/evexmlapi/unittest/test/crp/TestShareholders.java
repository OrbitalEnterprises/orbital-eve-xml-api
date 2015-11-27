package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.crp.IShareholder;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestShareholders extends ApiTestSetup {

	@Test
	public void testGetShareholders() throws IOException, ParseException,
			SAXException {
		// Retrieve response
		ICorporationAPI request = requestor.getCorporationAPIService(0,
				"na", 0L);
		Collection<IShareholder> response = request.requestShareholders();

		// Compute XML for comparison
		String testData = CorpShareholdersConverter.convert(request, response);

		// Perform test
		ApiTestConnector.testComparison(ApiTestConnector.CORP_SHAREHOLDERS_CTL,
				ApiTestConnector.CORP_SHAREHOLDERS_TST,
				ApiTestConnector.CORP_SHAREHOLDERS_OUT, testData);
	}

}
