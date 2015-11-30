package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.util.Collection;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.IMailList;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharMailingListsConverter extends ResponseConverter {

	public static String convert(ICharacterAPI request,
			Collection<IMailList> response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);

		builder.append("<result>\n");
		builder.append("<rowset name=\"mailingLists\" key=\"listID\" columns=\"listID,displayName\"");

		if (response.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");

			for (IMailList next : response) {
				builder.append("<row listID=\"").append(next.getListID());
				builder.append("\" displayName=\"").append(
						next.getDisplayName());
				builder.append("\" />\n");
			}

			builder.append("</rowset>\n");
		}

		builder.append("</result>\n");

		convertCloser(request, builder);
		return builder.toString();
	}
}
