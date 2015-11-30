package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.util.Collection;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.crp.ICorporationMedal;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CorpMedalsConverter extends ResponseConverter {

	public static String convert(ICorporationAPI request,
			Collection<ICorporationMedal> response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);
		builder.append("<result>\n");

		builder.append("<rowset name=\"medals\" key=\"medalID\" columns=\"medalID,title,description,creatorID,created\"");
		if (response.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");

			for (ICorporationMedal next : response) {
				builder.append("<row medalID=\"").append(next.getMedalID());
				builder.append("\" title=\"").append(next.getTitle());
				builder.append("\" description=\"").append(
						next.getDescription());
				builder.append("\" creatorID=\"").append(next.getCreatorID());
				builder.append("\" created=\"").append(
						toEveDateFormat(next.getCreated()));
				builder.append("\" />\n");
			}

			builder.append("</rowset>\n");
		}

		builder.append("</result>\n");
		convertCloser(request, builder);
		return builder.toString();
	}

}
