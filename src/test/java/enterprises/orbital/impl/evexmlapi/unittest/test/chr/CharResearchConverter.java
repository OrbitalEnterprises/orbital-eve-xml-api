package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.util.Collection;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.IResearchAgent;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharResearchConverter extends ResponseConverter {

	public static String convert(ICharacterAPI request,
			Collection<IResearchAgent> response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);
		builder.append("<result>\n");

		builder.append("<rowset name=\"research\" key=\"agentID\" columns=\"agentID,skillTypeID,researchStartDate,pointsPerDay,remainderPoints\"");

		if (response.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");

			for (IResearchAgent next : response) {
				builder.append("<row agentID=\"").append(next.getAgentID());
				builder.append("\" skillTypeID=\"").append(
						next.getSkillTypeID());
				builder.append("\" researchStartDate=\"").append(
						toEveDateFormat(next.getResearchStartDate()));
				builder.append("\" pointsPerDay=\"").append(
						next.getPointsPerDay());
				builder.append("\" remainderPoints=\"").append(
						next.getRemainderPoints());
				builder.append("\" />\n");
			}

			builder.append("</rowset>\n");
		}

		builder.append("</result>\n");
		convertCloser(request, builder);
		return builder.toString();
	}
}
