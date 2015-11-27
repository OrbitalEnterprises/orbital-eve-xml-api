package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.util.ArrayList;
import java.util.Collection;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.ICharacterMedal;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharMedalsConverter extends ResponseConverter {

	public static String convert(ICharacterAPI request,
			Collection<ICharacterMedal> response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);
		builder.append("<result>\n");

		Collection<ICharacterMedal> current = new ArrayList<ICharacterMedal>();
		Collection<ICharacterMedal> other = new ArrayList<ICharacterMedal>();

		for (ICharacterMedal next : response)
			if (next.getCorporationID() == 0)
				current.add(next);
			else
				other.add(next);

		// Do current medals
		builder.append("<rowset name=\"currentCorporation\" key=\"medalID\" columns=\"medalID,reason,status,issuerID,issued\"");
		if (current.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");

			for (ICharacterMedal next : current) {
				builder.append("<row medalID=\"").append(next.getMedalID());
				builder.append("\" reason=\"").append(next.getReason());
				builder.append("\" status=\"").append(next.getStatus());
				builder.append("\" issuerID=\"").append(next.getIssuerID());
				builder.append("\" issued=\"").append(
						toEveDateFormat(next.getIssued()));
				builder.append("\" />\n");
			}

			builder.append("</rowset>\n");
		}

		// Do other medals
		builder.append("<rowset name=\"otherCorporations\" key=\"medalID\" columns=\"medalID,reason,status,issuerID,issued,corporationID,title,description\"");
		if (other.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");

			for (ICharacterMedal next : other) {
				builder.append("<row medalID=\"").append(next.getMedalID());
				builder.append("\" reason=\"").append(next.getReason());
				builder.append("\" status=\"").append(next.getStatus());
				builder.append("\" issuerID=\"").append(next.getIssuerID());
				builder.append("\" issued=\"").append(
						toEveDateFormat(next.getIssued()));
				builder.append("\" corporationID=\"").append(
						next.getCorporationID());
				builder.append("\" title=\"").append(next.getTitle());
				builder.append("\" description=\"").append(
						next.getDescription());
				builder.append("\" />\n");
			}

			builder.append("</rowset>\n");
		}

		builder.append("</result>\n");
		convertCloser(request, builder);
		return builder.toString();
	}
}
