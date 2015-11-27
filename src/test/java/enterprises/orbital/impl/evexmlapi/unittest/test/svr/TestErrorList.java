package enterprises.orbital.impl.evexmlapi.unittest.test.svr;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.eve.IError;
import enterprises.orbital.evexmlapi.eve.IEveAPI;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestErrorList extends ApiTestSetup {

	@Test
	public void testGetErrorList() throws IOException, ParseException,
			SAXException {
		// Retrieve response
		IEveAPI request = requestor.getEveAPIService();
		Collection<IError> response = request.requestErrors();

		// Compute XML for comparison
		String testData = EveErrorListConverter.convert(request, response);

		// Perform test
		ApiTestConnector.testComparison(ApiTestConnector.EVE_ERROR_LIST_CTL,
				ApiTestConnector.EVE_ERROR_LIST_TST,
				ApiTestConnector.EVE_ERROR_LIST_OUT, testData);
	}

}
