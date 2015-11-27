package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.INotificationText;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestNotificationTexts extends ApiTestSetup {

	@Test
	public void testGetNotificationTexts() throws IOException, ParseException,
			SAXException {
		// Retrieve response
		ICharacterAPI request = requestor.getCharacterAPIService(0,
				"na", 0L);
		Collection<INotificationText> response = request
				.requestNotificationTexts(0);

		// Compute XML for comparison
		String testData = CharNotificationsTextsConverter.convert(request,
				response);

		// Perform test
		ApiTestConnector.testComparison(ApiTestConnector.CHAR_NOTIFICATION_TEXTS_CTL,
				ApiTestConnector.CHAR_NOTIFICATION_TEXTS_TST,
				ApiTestConnector.CHAR_NOTIFICATION_TEXTS_OUT, testData);
	}

}
