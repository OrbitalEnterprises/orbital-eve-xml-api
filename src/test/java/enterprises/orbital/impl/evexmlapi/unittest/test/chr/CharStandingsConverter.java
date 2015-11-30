package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.util.List;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.shared.IStanding;
import enterprises.orbital.evexmlapi.shared.IStandingSet;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharStandingsConverter extends ResponseConverter {

  public static String convert(ICharacterAPI request, IStandingSet response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result");
    if (response.getAgentStandings().size() == 0 && response.getNPCCorporationStandings().size() == 0 && response.getFactionStandings().size() == 0)
      builder.append(" />\n");
    else {
      List<IStanding> agents = response.getAgentStandings();
      List<IStanding> corps = response.getNPCCorporationStandings();
      List<IStanding> factions = response.getFactionStandings();

      builder.append(">\n");
      builder.append("<characterNPCStandings>\n");

      // agents
      builder.append("<rowset name=\"agents\" key=\"fromID\" columns=\"fromID,fromName,standing\"");
      if (agents.size() == 0)
        builder.append(" />\n");
      else {
        builder.append(">\n");
        for (IStanding next : agents)
          dumpStanding(next, builder);
        builder.append("</rowset>\n");
      }

      // NPCCorporations
      builder.append("<rowset name=\"NPCCorporations\" key=\"fromID\" columns=\"fromID,fromName,standing\"");
      if (corps.size() == 0)
        builder.append(" />\n");
      else {
        builder.append(">\n");
        for (IStanding next : corps)
          dumpStanding(next, builder);
        builder.append("</rowset>\n");
      }

      // factions
      builder.append("<rowset name=\"factions\" key=\"fromID\" columns=\"fromID,fromName,standing\"");
      if (factions.size() == 0)
        builder.append(" />\n");
      else {
        builder.append(">\n");
        for (IStanding next : factions)
          dumpStanding(next, builder);
        builder.append("</rowset>\n");
      }

      builder.append("</characterNPCStandings>\n");
      builder.append("</result>\n");
    }

    convertCloser(request, builder);
    return builder.toString();
  }

  protected static void dumpStanding(IStanding standing, StringBuilder builder) {
    builder.append("<row fromID=\"").append(standing.getFromID());
    builder.append("\" fromName=\"").append(standing.getFromName());
    builder.append("\" standing=\"").append(String.format("%1.2f", standing.getStanding()));
    builder.append("\" />\n");
  }
}
