package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.util.Collection;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.INotification;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharNotificationsConverter extends ResponseConverter {

	public static String convert(ICharacterAPI request,
			Collection<INotification> response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);
		builder.append("<result>\n");

		builder.append("<rowset name=\"notifications\" key=\"notificationID\" columns=\"notificationID,typeID,senderID,sentDate,read\"");

		if (response.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");

			for (INotification next : response) {
				builder.append("<row notificationID=\"").append(
						next.getNotificationID());
				builder.append("\" typeID=\"").append(next.getTypeID());
				builder.append("\" senderID=\"").append(next.getSenderID());
				builder.append("\" sentDate=\"").append(
						toEveDateFormat(next.getSentDate()));
				builder.append("\" read=\"").append(next.isRead() ? 1 : 0);
				builder.append("\" />\n");
			}

			builder.append("</rowset>\n");
		}

		builder.append("</result>\n");
		convertCloser(request, builder);
		return builder.toString();
	}
}
