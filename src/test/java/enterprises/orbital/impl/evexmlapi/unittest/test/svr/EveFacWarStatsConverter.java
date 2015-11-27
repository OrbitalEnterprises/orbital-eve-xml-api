package enterprises.orbital.impl.evexmlapi.unittest.test.svr;

import enterprises.orbital.evexmlapi.eve.IEveAPI;
import enterprises.orbital.evexmlapi.eve.IFacWarSummary;
import enterprises.orbital.evexmlapi.eve.IFactionStats;
import enterprises.orbital.evexmlapi.eve.IFactionWar;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class EveFacWarStatsConverter extends ResponseConverter {

	public static String convert(IEveAPI request, IFacWarSummary response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);

		builder.append("<result>\n");
		builder.append("<totals>\n");
		builder.append("<killsYesterday>").append(response.getKillsYesterday())
				.append("</killsYesterday>\n");
		builder.append("<killsLastWeek>").append(response.getKillsLastWeek())
				.append("</killsLastWeek>\n");
		builder.append("<killsTotal>").append(response.getKillsTotal())
				.append("</killsTotal>\n");
		builder.append("<victoryPointsYesterday>")
				.append(response.getVictoryPointsYesterday())
				.append("</victoryPointsYesterday>\n");
		builder.append("<victoryPointsLastWeek>")
				.append(response.getVictoryPointsLastWeek())
				.append("</victoryPointsLastWeek>\n");
		builder.append("<victoryPointsTotal>")
				.append(response.getVictoryPointsTotal())
				.append("</victoryPointsTotal>\n");
		builder.append("</totals>\n");

		builder.append("<rowset name=\"factions\" key=\"factionID\" columns=\"factionID,factionName,pilots,systemsControlled,killsYesterday,killsLastWeek,killsTotal,victoryPointsYesterday,victoryPointsLastWeek,victoryPointsTotal\"");
		if (response.getFactions().size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");

			for (IFactionStats next : response.getFactions()) {
				builder.append("<row factionID=\"").append(next.getFactionID());
				builder.append("\" factionName=\"").append(
						next.getFactionName());
				builder.append("\" pilots=\"").append(next.getPilots());
				builder.append("\" systemsControlled=\"").append(
						next.getSystemsControlled());
				builder.append("\" killsYesterday=\"").append(
						next.getKillsYesterday());
				builder.append("\" killsLastWeek=\"").append(
						next.getKillsLastWeek());
				builder.append("\" killsTotal=\"").append(next.getKillsTotal());
				builder.append("\" victoryPointsYesterday=\"").append(
						next.getVictoryPointsYesterday());
				builder.append("\" victoryPointsLastWeek=\"").append(
						next.getVictoryPointsLastWeek());
				builder.append("\" victoryPointsTotal=\"").append(
						next.getVictoryPointsTotal());
				builder.append("\" />\n");
			}
			builder.append("</rowset>\n");
		}

		builder.append("<rowset name=\"factionWars\" columns=\"factionID,factionName,againstID,againstName\"");
		if (response.getWars().size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");

			for (IFactionWar next : response.getWars()) {
				builder.append("<row factionID=\"").append(next.getFactionID());
				builder.append("\" factionName=\"").append(
						next.getFactionName());
				builder.append("\" againstID=\"").append(next.getAgainstID());
				builder.append("\" againstName=\"").append(
						next.getAgainstName());
				builder.append("\" />\n");
			}

			builder.append("</rowset>\n");
		}

		builder.append("</result>\n");

		convertCloser(request, builder);
		return builder.toString();
	}
}
