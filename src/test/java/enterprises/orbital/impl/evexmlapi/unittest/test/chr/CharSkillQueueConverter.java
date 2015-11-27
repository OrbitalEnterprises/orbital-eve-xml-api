package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.util.Collection;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.ISkillInQueue;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharSkillQueueConverter extends ResponseConverter {

	public static String convert(ICharacterAPI request,
			Collection<ISkillInQueue> response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);

		builder.append("<result>\n");
		builder.append("<rowset name=\"skillqueue\" key=\"queuePosition\" columns=\"queuePosition,typeID,level,startSP,endSP,startTime,endTime\"");
		if (response.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");

			for (ISkillInQueue next : response) {
				builder.append("<row queuePosition=\"").append(
						next.getQueuePosition());
				builder.append("\" typeID=\"").append(next.getTypeID());
				builder.append("\" level=\"").append(next.getLevel());
				builder.append("\" startSP=\"").append(next.getStartSP());
				builder.append("\" endSP=\"").append(next.getEndSP());
				builder.append("\" startTime=\"").append(
						toEveDateFormat(next.getStartTime()));
				builder.append("\" endTime=\"").append(
						toEveDateFormat(next.getEndTime()));
				builder.append("\" />\n");
			}

			builder.append("</rowset>\n");
		}

		builder.append("</result>\n");

		convertCloser(request, builder);
		return builder.toString();
	}
}
