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

public class TestCharacterName extends ApiTestSetup {

	@Test
	public void testGetCharacterName() throws IOException, ParseException,
			SAXException {
		// Retrieve response
		IEveAPI request = requestor.getEveAPIService();
		Collection<ICharacterLookup> response = request.requestCharacterName(0);

		// Compute XML for comparison
		String testData = EveCharacterNameConverter.convert(request, response);

		// Perform test
		ApiTestConnector.testComparison(ApiTestConnector.EVE_CHARACTER_NAME_CTL,
				ApiTestConnector.EVE_CHARACTER_NAME_TST,
				ApiTestConnector.EVE_CHARACTER_NAME_OUT, testData);
	}

}
