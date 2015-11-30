package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.util.Collection;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.crp.IMemberMedal;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CorpMemberMedalsConverter extends ResponseConverter {

	public static String convert(ICorporationAPI request,
			Collection<IMemberMedal> response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);
		builder.append("<result>\n");

		builder.append("<rowset name=\"issuedMedals\" key=\"medalID\" columns=\"medalID,characterID,reason,status,issuerID,issued\"");
		if (response.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");

			for (IMemberMedal next : response) {
				builder.append("<row medalID=\"").append(next.getMedalID());
				builder.append("\" characterID=\"").append(
						next.getCharacterID());
				builder.append("\" reason=\"").append(next.getReason());
				builder.append("\" status=\"").append(next.getStatus());
				builder.append("\" issuerID=\"").append(next.getIssuerID());
				builder.append("\" issued=\"").append(
						toEveDateFormat(next.getIssued()));
				builder.append("\" />\n");
			}

			builder.append("</rowset>\n");
		}

		builder.append("</result>\n");
		convertCloser(request, builder);
		return builder.toString();
	}

}
