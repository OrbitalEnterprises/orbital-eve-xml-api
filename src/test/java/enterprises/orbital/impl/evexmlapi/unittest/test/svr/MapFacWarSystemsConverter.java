package enterprises.orbital.impl.evexmlapi.unittest.test.svr;

import java.util.Collection;

import enterprises.orbital.evexmlapi.map.IFacWarSystem;
import enterprises.orbital.evexmlapi.map.IMapAPI;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class MapFacWarSystemsConverter extends ResponseConverter {

	public static String convert(IMapAPI request,
			Collection<IFacWarSystem> response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);
		builder.append("<result>\n");

		builder.append("<rowset name=\"solarSystems\" key=\"solarSystemID\" columns=\"solarSystemID,solarSystemName,occupyingFactionID,owningFactionID,occupyingFactionName,owningFactionName,contested\"");
		if (response.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");
			for (IFacWarSystem next : response) {

				builder.append("<row solarSystemID=\"").append(
						next.getSolarSystemID());
				builder.append("\" solarSystemName=\"").append(
						next.getSolarSystemName());
				builder.append("\" occupyingFactionID=\"").append(
						next.getOccupyingFactionID());
				builder.append("\" owningFactionID=\"").append(
						next.getOwningFactionID());
				builder.append("\" occupyingFactionName=\"").append(
						next.getOccupyingFactionName());
				builder.append("\" owningFactionName=\"").append(
						next.getOwningFactionName());
				builder.append("\" contested=\"").append(
						next.isContested() ? "True" : "False");
				builder.append("\" />\n");
			}
			builder.append("</rowset>\n");
		}

		builder.append("</result>\n");

		convertCloser(request, builder);
		return builder.toString();
	}
}
