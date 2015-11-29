package enterprises.orbital.impl.evexmlapi.unittest.test.map;

import enterprises.orbital.evexmlapi.map.IMapAPI;
import enterprises.orbital.evexmlapi.map.ISovereignty;
import enterprises.orbital.evexmlapi.map.ISystemSovereignty;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class MapSovereigntyConverter extends ResponseConverter {

	public static String convert(IMapAPI request, ISovereignty response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);
		builder.append("<result>\n");

		builder.append("<rowset name=\"solarSystems\" key=\"solarSystemID\" columns=\"solarSystemID,allianceID,factionID,solarSystemName,corporationID\"");
		if (response.getSystemSovereignty().size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");
			for (ISystemSovereignty next : response.getSystemSovereignty()) {
				builder.append("<row solarSystemID=\"").append(
						next.getSolarSystemID());
				builder.append("\" allianceID=\"").append(next.getAllianceID());
				builder.append("\" factionID=\"").append(next.getFactionID());
				builder.append("\" solarSystemName=\"").append(
						next.getSolarSystemName());
				builder.append("\" corporationID=\"").append(
						next.getCorporationID());
				builder.append("\" />\n");
			}
			builder.append("</rowset>\n");
		}

		builder.append("<dataTime>").append(
				toEveDateFormat(response.getDataTime()));
		builder.append("</dataTime>\n");

		builder.append("</result>\n");

		convertCloser(request, builder);
		return builder.toString();
	}
}
