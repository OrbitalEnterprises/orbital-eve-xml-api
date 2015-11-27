package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.IUpcomingCalendarEvent;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestUpcomingCalendarEvents extends ApiTestSetup {

	@Test
	public void testGetCalendarEventAttendees() throws IOException,
			ParseException, SAXException {
		// Retrieve response
		ICharacterAPI request = requestor.getCharacterAPIService(0,
				"na", 0L);
		Collection<IUpcomingCalendarEvent> response = request
				.requestUpcomingCalendarEvents();

		// Compute XML for comparison
		String testData = CharUpcomingCalendarEventsConverter.convert(request,
				response);

		// Perform test
		ApiTestConnector.testComparison(
				ApiTestConnector.CHAR_UPCOMING_CALENDAR_EVENTS_CTL,
				ApiTestConnector.CHAR_UPCOMING_CALENDAR_EVENTS_TST,
				ApiTestConnector.CHAR_UPCOMING_CALENDAR_EVENTS_OUT, testData);
	}

}
