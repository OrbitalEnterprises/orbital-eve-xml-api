package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.util.Collection;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.INotificationText;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharNotificationsTextsConverter extends ResponseConverter {

	public static String convert(ICharacterAPI req,
			Collection<INotificationText> response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(req, builder);
		builder.append("<result>\n");

		builder.append("<rowset name=\"notifications\" key=\"notificationID\" columns=\"notificationID\"");

		if (response.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");

			for (INotificationText next : response) {

				builder.append("<row notificationID=\"")
						.append(next.getNotificationID()).append("\" >");
				builder.append("<![CDATA[");
				builder.append(next.getText());
				builder.append("]]>");
				builder.append("</row>\n");
			}
			builder.append("</rowset>\n");
		}

		builder.append("</result>\n");
		convertCloser(req, builder);
		return builder.toString();
	}

}
