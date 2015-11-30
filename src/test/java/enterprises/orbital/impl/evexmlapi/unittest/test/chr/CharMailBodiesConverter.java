package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.util.Collection;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.IMailBody;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharMailBodiesConverter extends ResponseConverter {

	public static String convert(ICharacterAPI req,
			Collection<IMailBody> response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(req, builder);
		builder.append("<result");
		if (response.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");
			builder.append("<rowset name=\"messages\" key=\"messageID\" columns=\"messageID\" >\n");
			for (IMailBody next : response) {
				builder.append("<row messageID=\"").append(next.getMessageID())
						.append("\" >");
				builder.append("<![CDATA[");
				builder.append(next.getBody());
				builder.append("]]>");
				builder.append("</row>\n");
			}
			builder.append("</rowset>\n");
			builder.append("</result>\n");
		}

		convertCloser(req, builder);
		return builder.toString();
	}

}
