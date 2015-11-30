package enterprises.orbital.impl.evexmlapi.unittest.test.eve;

import java.util.Collection;

import enterprises.orbital.evexmlapi.eve.IError;
import enterprises.orbital.evexmlapi.eve.IEveAPI;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class EveErrorListConverter extends ResponseConverter {

	public static String convert(IEveAPI request,
			Collection<IError> response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);
		builder.append("<result>\n");

		builder.append("<rowset name=\"errors\" key=\"errorCode\" columns=\"errorCode,errorText\"");
		if (response.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");
			for (IError next : response) {
				builder.append("<row errorCode=\"").append(next.getErrorCode());
				builder.append("\" errorText=\"").append(next.getErrorText());
				builder.append("\" />\n");
			}
			builder.append("</rowset>\n");
		}

		builder.append("</result>\n");

		convertCloser(request, builder);
		return builder.toString();
	}
}
