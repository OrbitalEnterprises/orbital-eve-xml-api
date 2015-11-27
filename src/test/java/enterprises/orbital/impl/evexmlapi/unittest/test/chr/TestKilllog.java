package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.shared.IKill;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestKilllog extends ApiTestSetup {

	@Test
	public void testGetKillLog() throws IOException, ParseException,
			SAXException {
		// Retrieve response
		ICharacterAPI request = requestor.getCharacterAPIService(0,
				"na", 0L);
		Collection<IKill> response = request.requestKillMails();

		// Compute XML for comparison
		String testData = CharKilllogConverter.convert(request, response);

		// Perform test
		ApiTestConnector.testComparison(ApiTestConnector.CHAR_KILLLOG_CTL,
				ApiTestConnector.CHAR_KILLLOG_TST, ApiTestConnector.CHAR_KILLLOG_OUT,
				testData);
	}

}
