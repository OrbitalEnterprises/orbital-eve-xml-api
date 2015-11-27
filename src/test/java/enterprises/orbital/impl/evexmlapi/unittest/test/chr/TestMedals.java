package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.ICharacterMedal;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestMedals extends ApiTestSetup {

	@Test
	public void testGetMedals() throws IOException, ParseException,
			SAXException {
		// Retrieve response
		ICharacterAPI request = requestor.getCharacterAPIService(0,
				"na", 0L);
		Collection<ICharacterMedal> response = request.requestMedals();

		// Compute XML for comparison
		String testData = CharMedalsConverter.convert(request, response);

		// Perform test
		ApiTestConnector.testComparison(ApiTestConnector.CHAR_MEDALS_CTL,
				ApiTestConnector.CHAR_MEDALS_TST, ApiTestConnector.CHAR_MEDALS_OUT,
				testData);
	}

}
