package enterprises.orbital.impl.evexmlapi.unittest.test.act;

import java.util.Collection;

import enterprises.orbital.evexmlapi.act.IAccountAPI;
import enterprises.orbital.evexmlapi.act.ICharacter;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class AcctCharactersConverter extends ResponseConverter {

	public static String convert(IAccountAPI request,
			Collection<ICharacter> response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);

		builder.append("<result>\n");
		builder.append("<rowset name=\"characters\" key=\"characterID\" columns=\"name,characterID,corporationName,corporationID\"");
		if (response.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");
			for (ICharacter next : response) {
				builder.append("<row name=\"").append(next.getName());
				builder.append("\" characterID=\"").append(
						next.getCharacterID());
				builder.append("\" corporationName=\"").append(
						next.getCorporationName());
				builder.append("\" corporationID=\"").append(
						next.getCorporationID());
				builder.append("\" />\n");
			}

			builder.append("</rowset>\n");
		}

		builder.append("</result>\n");

		convertCloser(request, builder);

		return builder.toString();
	}
}
