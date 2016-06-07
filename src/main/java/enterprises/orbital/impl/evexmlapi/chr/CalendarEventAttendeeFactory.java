package enterprises.orbital.impl.evexmlapi.chr;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.xml.sax.Attributes;

public class CalendarEventAttendeeFactory extends AbstractObjectCreationFactory {
	@Override
	public CalendarEventAttendee createObject(Attributes attr) {
		CalendarEventAttendee next = new CalendarEventAttendee();

		next.setEventID(Integer.valueOf(attr.getValue("", "eventID")));
		next.setCharacterID(Long.valueOf(attr.getValue("", "characterID")));
		next.setCharacterName(attr.getValue("", "characterName"));
		next.setResponse(attr.getValue("", "response"));

		return next;
	}
}
