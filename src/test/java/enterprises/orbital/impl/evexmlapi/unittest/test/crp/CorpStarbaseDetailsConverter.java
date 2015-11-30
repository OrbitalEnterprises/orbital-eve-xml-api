package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.crp.IFuel;
import enterprises.orbital.evexmlapi.crp.IStarbaseDetail;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CorpStarbaseDetailsConverter extends ResponseConverter {

	public static String convert(ICorporationAPI request,
			IStarbaseDetail response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);
		builder.append("<result>\n");

		builder.append("<state>").append(response.getState())
				.append("</state>\n");
		builder.append("<stateTimestamp>").append(
				toEveDateFormat(response.getStateTimestamp()));
		builder.append("</stateTimestamp>\n");
		builder.append("<onlineTimestamp>").append(
				toEveDateFormat(response.getOnlineTimestamp()));
		builder.append("</onlineTimestamp>\n");
		builder.append("<generalSettings>\n");
		builder.append("<usageFlags>").append(response.getUsageFlags())
				.append("</usageFlags>\n");
		builder.append("<deployFlags>").append(response.getDeployFlags())
				.append("</deployFlags>\n");
		builder.append("<allowCorporationMembers>").append(
				response.isAllowCorporationMembers() ? 1 : 0);
		builder.append("</allowCorporationMembers>\n");
		builder.append("<allowAllianceMembers>").append(
				response.isAllowAllianceMembers() ? 1 : 0);
		builder.append("</allowAllianceMembers>\n");
		builder.append("</generalSettings>\n");
		builder.append("<combatSettings>\n");
		builder.append("<useStandingsFrom ownerID=\"").append(
				response.getUseStandingsFrom());
		builder.append("\" />\n");
		builder.append("<onStandingDrop standing=\"").append(
				response.getOnStandingDrop().getStanding());
		builder.append("\" />\n");
		builder.append("<onStatusDrop enabled=\"").append(
				response.getOnStatusDrop().isEnabled() ? 1 : 0);
		builder.append("\" standing=\"").append(
				response.getOnStatusDrop().getStanding());
		builder.append("\" />\n");
		builder.append("<onAggression enabled=\"").append(
				response.getOnAggression().isEnabled() ? 1 : 0);
		builder.append("\" />\n");
		builder.append("<onCorporationWar enabled=\"").append(
				response.getOnCorporationWar().isEnabled() ? 1 : 0);
		builder.append("\" />\n");
		builder.append("</combatSettings>\n");
		builder.append("<rowset name=\"fuel\" key=\"typeID\" columns=\"typeID,quantity\"");
		if (response.getFuelMap().size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");
			for (IFuel next : response.getFuelMap()) {
				builder.append("<row typeID=\"").append(next.getTypeID());
				builder.append("\" quantity=\"").append(next.getQuantity());
				builder.append("\" />\n");
			}
			builder.append("</rowset>\n");
		}

		builder.append("</result>\n");
		convertCloser(request, builder);
		return builder.toString();
	}
}
