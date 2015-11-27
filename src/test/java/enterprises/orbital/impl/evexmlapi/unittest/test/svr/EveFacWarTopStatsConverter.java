package enterprises.orbital.impl.evexmlapi.unittest.test.svr;

import java.util.Collection;

import enterprises.orbital.evexmlapi.eve.ICharacterKillStat;
import enterprises.orbital.evexmlapi.eve.ICharacterVictoryPointStat;
import enterprises.orbital.evexmlapi.eve.ICorporationKillStat;
import enterprises.orbital.evexmlapi.eve.ICorporationVictoryPointStat;
import enterprises.orbital.evexmlapi.eve.IEveAPI;
import enterprises.orbital.evexmlapi.eve.IFacWarTopSummary;
import enterprises.orbital.evexmlapi.eve.IFactionKillStat;
import enterprises.orbital.evexmlapi.eve.IFactionVictoryPointStat;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class EveFacWarTopStatsConverter extends ResponseConverter {

	public static String convert(IEveAPI request,
			IFacWarTopSummary response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);

		builder.append("<result>\n");
		builder.append("<characters>\n");

		dumpCharKills("KillsYesterday", response.getCharacterStats()
				.getKillsYesterday(), builder);
		dumpCharKills("KillsLastWeek", response.getCharacterStats()
				.getKillsLastWeek(), builder);
		dumpCharKills("KillsTotal", response.getCharacterStats()
				.getKillsTotal(), builder);

		dumpCharVPs("VictoryPointsYesterday", response.getCharacterStats()
				.getVictoryPointsYesterday(), builder);
		dumpCharVPs("VictoryPointsLastWeek", response.getCharacterStats()
				.getVictoryPointsLastWeek(), builder);
		dumpCharVPs("VictoryPointsTotal", response.getCharacterStats()
				.getVictoryPointsTotal(), builder);

		builder.append("</characters>\n");
		builder.append("<corporations>\n");

		dumpCorpKills("KillsYesterday", response.getCorporationStats()
				.getKillsYesterday(), builder);
		dumpCorpKills("KillsLastWeek", response.getCorporationStats()
				.getKillsLastWeek(), builder);
		dumpCorpKills("KillsTotal", response.getCorporationStats()
				.getKillsTotal(), builder);

		dumpCorpVPs("VictoryPointsYesterday", response.getCorporationStats()
				.getVictoryPointsYesterday(), builder);
		dumpCorpVPs("VictoryPointsLastWeek", response.getCorporationStats()
				.getVictoryPointsLastWeek(), builder);
		dumpCorpVPs("VictoryPointsTotal", response.getCorporationStats()
				.getVictoryPointsTotal(), builder);

		builder.append("</corporations>\n");
		builder.append("<factions>\n");

		dumpFactionKills("KillsYesterday", response.getFactionStats()
				.getKillsYesterday(), builder);
		dumpFactionKills("KillsLastWeek", response.getFactionStats()
				.getKillsLastWeek(), builder);
		dumpFactionKills("KillsTotal", response.getFactionStats()
				.getKillsTotal(), builder);

		dumpFactionVPs("VictoryPointsYesterday", response.getFactionStats()
				.getVictoryPointsYesterday(), builder);
		dumpFactionVPs("VictoryPointsLastWeek", response.getFactionStats()
				.getVictoryPointsLastWeek(), builder);
		dumpFactionVPs("VictoryPointsTotal", response.getFactionStats()
				.getVictoryPointsTotal(), builder);

		builder.append("</factions>\n");
		builder.append("</result>\n");

		convertCloser(request, builder);
		return builder.toString();
	}

	protected static void dumpCharKills(String type,
			Collection<ICharacterKillStat> results, StringBuilder builder) {
		builder.append("<rowset name=\"").append(type);
		builder.append("\" key=\"characterID\" columns=\"characterID,characterName,kills\"");
		if (results.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");
			for (ICharacterKillStat next : results) {
				builder.append("<row characterID=\"").append(
						next.getCharacterID());
				builder.append("\" characterName=\"").append(
						next.getCharacterName());
				builder.append("\" kills=\"").append(next.getKills());
				builder.append("\" />\n");
			}
			builder.append("</rowset>\n");
		}
	}

	protected static void dumpCharVPs(String type,
			Collection<ICharacterVictoryPointStat> results,
			StringBuilder builder) {
		builder.append("<rowset name=\"").append(type);
		builder.append("\" key=\"characterID\" columns=\"characterID,characterName,victoryPoints\"");
		if (results.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");
			for (ICharacterVictoryPointStat next : results) {
				builder.append("<row characterID=\"").append(
						next.getCharacterID());
				builder.append("\" characterName=\"").append(
						next.getCharacterName());
				builder.append("\" victoryPoints=\"").append(
						next.getVictoryPoints());
				builder.append("\" />\n");
			}
			builder.append("</rowset>\n");
		}
	}

	protected static void dumpCorpKills(String type,
			Collection<ICorporationKillStat> results, StringBuilder builder) {
		builder.append("<rowset name=\"").append(type);
		builder.append("\" key=\"corporationID\" columns=\"corporationID,corporationName,kills\"");
		if (results.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");
			for (ICorporationKillStat next : results) {
				builder.append("<row corporationID=\"").append(
						next.getCorporationID());
				builder.append("\" corporationName=\"").append(
						next.getCorporationName());
				builder.append("\" kills=\"").append(next.getKills());
				builder.append("\" />\n");
			}
			builder.append("</rowset>\n");
		}
	}

	protected static void dumpCorpVPs(String type,
			Collection<ICorporationVictoryPointStat> results,
			StringBuilder builder) {
		builder.append("<rowset name=\"").append(type);
		builder.append("\" key=\"corporationID\" columns=\"corporationID,corporationName,victoryPoints\"");
		if (results.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");
			for (ICorporationVictoryPointStat next : results) {
				builder.append("<row corporationID=\"").append(
						next.getCorporationID());
				builder.append("\" corporationName=\"").append(
						next.getCorporationName());
				builder.append("\" victoryPoints=\"").append(
						next.getVictoryPoints());
				builder.append("\" />\n");
			}
			builder.append("</rowset>\n");
		}
	}

	protected static void dumpFactionKills(String type,
			Collection<IFactionKillStat> results, StringBuilder builder) {
		builder.append("<rowset name=\"").append(type);
		builder.append("\" key=\"factionID\" columns=\"factionID,factionName,kills\"");
		if (results.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");
			for (IFactionKillStat next : results) {
				builder.append("<row factionID=\"").append(next.getFactionID());
				builder.append("\" factionName=\"").append(
						next.getFactionName());
				builder.append("\" kills=\"").append(next.getKills());
				builder.append("\" />\n");
			}
			builder.append("</rowset>\n");
		}
	}

	protected static void dumpFactionVPs(String type,
			Collection<IFactionVictoryPointStat> results, StringBuilder builder) {
		builder.append("<rowset name=\"").append(type);
		builder.append("\" key=\"factionID\" columns=\"factionID,factionName,victoryPoints\"");
		if (results.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");
			for (IFactionVictoryPointStat next : results) {
				builder.append("<row factionID=\"").append(next.getFactionID());
				builder.append("\" factionName=\"").append(
						next.getFactionName());
				builder.append("\" victoryPoints=\"").append(
						next.getVictoryPoints());
				builder.append("\" />\n");
			}
			builder.append("</rowset>\n");
		}
	}

}
