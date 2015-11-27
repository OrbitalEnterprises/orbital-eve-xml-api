package enterprises.orbital.impl.evexmlapi.unittest.test.svr;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.eve.ICharacterLookup;
import enterprises.orbital.evexmlapi.eve.IEveAPI;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestCharacterID extends ApiTestSetup {

	@Test
	public void testGetCharacterID() throws IOException, ParseException,
			SAXException {
		// Retrieve response
		IEveAPI request = requestor.getEveAPIService();
		Collection<ICharacterLookup> response = request
				.requestCharacterID("na");

		// Compute XML for comparison
		String testData = EveCharacterIDConverter.convert(request, response);

		// Perform test
		ApiTestConnector.testComparison(ApiTestConnector.EVE_CHARACTER_ID_CTL,
				ApiTestConnector.EVE_CHARACTER_ID_TST,
				ApiTestConnector.EVE_CHARACTER_ID_OUT, testData);
	}

}
