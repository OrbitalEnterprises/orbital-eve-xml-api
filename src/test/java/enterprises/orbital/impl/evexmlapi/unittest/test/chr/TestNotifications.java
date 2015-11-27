package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.INotification;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestNotifications extends ApiTestSetup {

	@Test
	public void testGetNotifications() throws IOException, ParseException,
			SAXException {
		// Retrieve response
		ICharacterAPI request = requestor.getCharacterAPIService(0,
				"na", 0L);
		Collection<INotification> response = request.requestNotifications();

		// Compute XML for comparison
		String testData = CharNotificationsConverter.convert(request, response);

		// Perform test
		ApiTestConnector.testComparison(ApiTestConnector.CHAR_NOTIFICATIONS_CTL,
				ApiTestConnector.CHAR_NOTIFICATIONS_TST,
				ApiTestConnector.CHAR_NOTIFICATIONS_OUT, testData);
	}

}
