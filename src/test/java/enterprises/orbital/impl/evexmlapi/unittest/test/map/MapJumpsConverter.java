package enterprises.orbital.impl.evexmlapi.unittest.test.map;

import enterprises.orbital.evexmlapi.map.IJump;
import enterprises.orbital.evexmlapi.map.IMapAPI;
import enterprises.orbital.evexmlapi.map.IMapJump;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class MapJumpsConverter extends ResponseConverter {

	public static String convert(IMapAPI request, IMapJump response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);
		builder.append("<result>\n");

		builder.append("<rowset name=\"solarSystems\" key=\"solarSystemID\" columns=\"solarSystemID,shipJumps\"");
		if (response.getJumps().size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");
			for (IJump next : response.getJumps()) {
				builder.append("<row solarSystemID=\"").append(
						next.getSolarSystemID());
				builder.append("\" shipJumps=\"").append(next.getShipJumps());
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
