package enterprises.orbital.impl.evexmlapi.unittest.test.svr;

import java.util.Collection;

import enterprises.orbital.evexmlapi.eve.ICharacterLookup;
import enterprises.orbital.evexmlapi.eve.IEveAPI;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class EveCharacterIDConverter extends ResponseConverter {

	public static String convert(IEveAPI request,
			Collection<ICharacterLookup> response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);
		builder.append("<result>\n");

		builder.append("<rowset name=\"characters\" key=\"characterID\" columns=\"name,characterID\"");
		if (response.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");
			for (ICharacterLookup next : response) {
				builder.append("<row name=\"").append(next.getName());
				builder.append("\" characterID=\"").append(
						next.getCharacterID());
				builder.append("\" />\n");
			}
			builder.append("</rowset>\n");
		}

		builder.append("</result>\n");

		convertCloser(request, builder);
		return builder.toString();
	}
}
