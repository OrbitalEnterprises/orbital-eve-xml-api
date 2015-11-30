package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.shared.IFacWarStats;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharFacWarStatsConverter extends ResponseConverter {

	public static String convert(ICharacterAPI request,
			IFacWarStats response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);

		builder.append("<result>\n");
		builder.append("<factionID>").append(response.getFactionID())
				.append("</factionID>\n");
		builder.append("<factionName>").append(response.getFactionName())
				.append("</factionName>\n");
		builder.append("<enlisted>")
				.append(toEveDateFormat(response.getEnlisted()))
				.append("</enlisted>\n");
		builder.append("<currentRank>").append(response.getCurrentRank())
				.append("</currentRank>\n");
		builder.append("<highestRank>").append(response.getHighestRank())
				.append("</highestRank>\n");
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

		builder.append("</result>\n");

		convertCloser(request, builder);
		return builder.toString();
	}
}
