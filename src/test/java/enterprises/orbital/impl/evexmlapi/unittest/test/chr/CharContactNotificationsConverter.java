package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.util.Collection;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.IContactNotification;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharContactNotificationsConverter extends ResponseConverter {

	public static String convert(ICharacterAPI request,
			Collection<IContactNotification> response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);
		builder.append("<result>\n");
		builder.append("<rowset name=\"contactNotifications\" key=\"notificationID\" columns=\"notificationID,senderID,senderName,sentDate,messageData\"");

		if (response.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");

			for (IContactNotification next : response) {
				builder.append("<row notificationID=\"").append(
						next.getNotificationID());
				builder.append("\" senderID=\"").append(next.getSenderID());
				builder.append("\" senderName=\"").append(next.getSenderName());
				builder.append("\" sentDate=\"").append(
						toEveDateFormat(next.getSentDate()));

				String messageData = next.getMessageData();
				messageData = messageData.replace("\n", "&#xA;");

				builder.append("\" messageData=\"").append(messageData);
				builder.append("\" />\n");
			}

			builder.append("</rowset>\n");
		}

		builder.append("</result>\n");
		convertCloser(request, builder);
		return builder.toString();
	}
}
