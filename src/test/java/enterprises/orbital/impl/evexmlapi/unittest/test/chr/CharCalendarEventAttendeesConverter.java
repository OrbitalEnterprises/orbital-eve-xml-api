package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.util.Collection;

import enterprises.orbital.evexmlapi.chr.ICalendarEventAttendee;
import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharCalendarEventAttendeesConverter extends ResponseConverter {

	public static String convert(ICharacterAPI request,
			Collection<ICalendarEventAttendee> response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);
		builder.append("<result");
		if (response.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");
			builder.append("<rowset name=\"eventAttendees\" key=\"eventID, characterID\" columns=\"eventID,characterID,characterName,response\">\n");

			for (ICalendarEventAttendee next : response) {
				builder.append("<row eventID=\"").append(next.getEventID());
				builder.append("\" characterID=\"").append(
						next.getCharacterID());
				builder.append("\" characterName=\"").append(
						next.getCharacterName());
				builder.append("\" response=\"").append(next.getResponse());
				builder.append("\" />\n");
			}

			builder.append("</rowset>\n");
			builder.append("</result>\n");
		}

		convertCloser(request, builder);
		return builder.toString();
	}
}
