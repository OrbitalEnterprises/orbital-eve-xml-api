package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.util.ArrayList;
import java.util.Collection;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.crp.IShareholder;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CorpShareholdersConverter extends ResponseConverter {

	public static String convert(ICorporationAPI request,
			Collection<IShareholder> response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);
		builder.append("<result>\n");

		Collection<IShareholder> corps = new ArrayList<IShareholder>();
		Collection<IShareholder> chars = new ArrayList<IShareholder>();

		for (IShareholder next : response)
			if (next.isCorporation())
				corps.add(next);
			else
				chars.add(next);

		builder.append("<rowset name=\"characters\" key=\"shareholderID\" columns=\"shareholderID,shareholderName,shareholderCorporationID,shareholderCorporationName,shares\"");
		if (chars.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");
			for (IShareholder next : chars) {
				builder.append("<row shareholderID=\"").append(
						next.getShareholderID());
				builder.append("\" shareholderName=\"").append(
						next.getShareholderName());
				builder.append("\" shareholderCorporationID=\"").append(
						next.getShareholderCorporationID());
				builder.append("\" shareholderCorporationName=\"").append(
						next.getShareholderCorporationName());
				builder.append("\" shares=\"").append(next.getShares());
				builder.append("\" />\n");
			}
			builder.append("</rowset>\n");
		}

		builder.append("<rowset name=\"corporations\" key=\"shareholderID\" columns=\"shareholderID,shareholderName,shares\"");
		if (corps.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");
			for (IShareholder next : corps) {
				builder.append("<row shareholderID=\"").append(
						next.getShareholderID());
				builder.append("\" shareholderName=\"").append(
						next.getShareholderName());
				builder.append("\" shares=\"").append(next.getShares());
				builder.append("\" />\n");
			}
			builder.append("</rowset>\n");
		}

		builder.append("</result>\n");
		convertCloser(request, builder);
		return builder.toString();
	}
}
