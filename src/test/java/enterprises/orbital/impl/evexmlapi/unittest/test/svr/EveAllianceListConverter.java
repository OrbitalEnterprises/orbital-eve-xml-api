package enterprises.orbital.impl.evexmlapi.unittest.test.svr;

import java.util.Collection;

import enterprises.orbital.evexmlapi.eve.IAlliance;
import enterprises.orbital.evexmlapi.eve.IEveAPI;
import enterprises.orbital.evexmlapi.eve.IMemberCorporation;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class EveAllianceListConverter extends ResponseConverter {

	public static String convert(IEveAPI request,
			Collection<IAlliance> response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);
		builder.append("<result>\n");

		builder.append("<rowset name=\"alliances\" key=\"allianceID\" columns=\"name,shortName,allianceID,executorCorpID,memberCount,startDate\"");
		if (response.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");

			for (IAlliance next : response) {
				builder.append("<row name=\"").append(next.getName());
				builder.append("\" shortName=\"").append(next.getShortName());
				builder.append("\" allianceID=\"").append(next.getAllianceID());
				builder.append("\" executorCorpID=\"").append(
						next.getExecutorCorpID());
				builder.append("\" memberCount=\"").append(
						next.getMemberCount());
				builder.append("\" startDate=\"").append(
						toEveDateFormat(next.getStartDate()));
				builder.append("\" >\n");

				builder.append("<rowset name=\"memberCorporations\" key=\"corporationID\" columns=\"corporationID,startDate\"");
				if (next.getMemberCorporations().size() == 0)
					builder.append(" />\n");
				else {
					builder.append(">\n");

					for (IMemberCorporation nextCorp : next
							.getMemberCorporations()) {
						builder.append("<row corporationID=\"").append(
								nextCorp.getCorporationID());
						builder.append("\" startDate=\"").append(
								toEveDateFormat(nextCorp.getStartDate()));
						builder.append("\" />\n");
					}
					builder.append("</rowset>\n");
				}

				builder.append("</row>\n");
			}
			builder.append("</rowset>\n");
		}

		builder.append("</result>\n");

		convertCloser(request, builder);
		return builder.toString();
	}
}
