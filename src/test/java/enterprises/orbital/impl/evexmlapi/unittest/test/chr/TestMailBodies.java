package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.IMailBody;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestMailBodies extends ApiTestSetup {

	@Test
	public void testGetCharMailBodies() throws IOException, ParseException,
			SAXException {
		// Retrieve response
		ICharacterAPI request = requestor.getCharacterAPIService(0,
				"na", 0L);
		Collection<IMailBody> response = request.requestMailBodies(0);

		// Compute XML for comparison
		String testData = CharMailBodiesConverter.convert(request, response);

		// Perform test
		ApiTestConnector.testComparison(ApiTestConnector.CHAR_MAIL_BODIES_CTL,
				ApiTestConnector.CHAR_MAIL_BODIES_TST,
				ApiTestConnector.CHAR_MAIL_BODIES_OUT, testData);
	}

}
