package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.util.Collection;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.IUpcomingCalendarEvent;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharUpcomingCalendarEventsConverter extends ResponseConverter {

	public static String convert(ICharacterAPI request,
			Collection<IUpcomingCalendarEvent> response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);
		builder.append("<result");
		if (response.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");
			builder.append("<rowset name=\"upcomingEvents\" key=\"eventID\" columns=\"eventID,ownerID,ownerName,eventDate,eventTitle,duration,importance,response,eventText\">\n");

			for (IUpcomingCalendarEvent next : response) {
				builder.append("<row eventID=\"").append(next.getEventID());
				builder.append("\" ownerID=\"").append(next.getOwnerID());
				builder.append("\" ownerName=\"").append(next.getOwnerName());
				builder.append("\" eventDate=\"").append(
						toEveDateFormat(next.getEventDate()));
				builder.append("\" eventTitle=\"").append(next.getEventTitle());
				builder.append("\" duration=\"").append(next.getDuration());
				builder.append("\" importance=\"").append(
						next.isImportant() ? 1 : 0);
				builder.append("\" response=\"").append(next.getResponse());
				String eventText = next.getEventText().replace("<", "&lt;")
						.replace(">", "&gt;").replace("\"", "&quot;");
				builder.append("\" eventText=\"").append(eventText);
				builder.append("\" />\n");
			}

			builder.append("</rowset>\n");
			builder.append("</result>\n");
		}

		convertCloser(request, builder);
		return builder.toString();
	}
}
