package enterprises.orbital.impl.evexmlapi.unittest.test.map;

import enterprises.orbital.evexmlapi.map.IMapAPI;
import enterprises.orbital.evexmlapi.map.IMapKill;
import enterprises.orbital.evexmlapi.map.ISystemKills;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class MapKillsConverter extends ResponseConverter {

	public static String convert(IMapAPI request, IMapKill response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);
		builder.append("<result>\n");

		builder.append("<rowset name=\"solarSystems\" key=\"solarSystemID\" columns=\"solarSystemID,shipKills,factionKills,podKills\"");
		if (response.getKills().size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");
			for (ISystemKills next : response.getKills()) {
				builder.append("<row solarSystemID=\"").append(
						next.getSolarSystemID());
				builder.append("\" shipKills=\"").append(next.getShipKills());
				builder.append("\" factionKills=\"").append(
						next.getFactionKills());
				builder.append("\" podKills=\"").append(next.getPodKills());
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
