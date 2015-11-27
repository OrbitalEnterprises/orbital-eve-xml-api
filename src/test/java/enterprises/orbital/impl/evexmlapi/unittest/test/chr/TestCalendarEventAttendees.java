package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.chr.ICalendarEventAttendee;
import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestCalendarEventAttendees extends ApiTestSetup {

	@Test
	public void testGetCalendarEventAttendees() throws IOException,
			ParseException, SAXException {
		// Retrieve response
		ICharacterAPI request = requestor.getCharacterAPIService(0,
				"na", 0L);
		Collection<ICalendarEventAttendee> response = request
				.requestCalendarEventAttendees(0);

		// Compute XML for comparison
		String testData = CharCalendarEventAttendeesConverter.convert(request,
				response);

		// Perform test
		ApiTestConnector.testComparison(
				ApiTestConnector.CHAR_CALENDAR_EVENT_ATTENDEES_CTL,
				ApiTestConnector.CHAR_CALENDAR_EVENT_ATTENDEES_TST,
				ApiTestConnector.CHAR_CALENDAR_EVENT_ATTENDEES_OUT, testData);
	}

}
