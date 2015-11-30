package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.ISkillInTraining;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharSkillInTrainingConverter extends ResponseConverter {

	public static String convert(ICharacterAPI request,
			ISkillInTraining response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);

		builder.append("<result>\n");
		if (!response.isSkillInTraining())
			builder.append("<skillInTraining>0</skillInTraining>\n");
		else {
			builder.append("<currentTQTime offset=\"0\">")
					.append(toEveDateFormat(response
							.getCurrentTrainingQueueTime()))
					.append("</currentTQTime>\n");
			builder.append("<trainingEndTime>")
					.append(toEveDateFormat(response.getTrainingEndTime()))
					.append("</trainingEndTime>\n");
			builder.append("<trainingStartTime>")
					.append(toEveDateFormat(response.getTrainingStartTime()))
					.append("</trainingStartTime>\n");
			builder.append("<trainingTypeID>")
					.append(response.getSkillTypeID())
					.append("</trainingTypeID>\n");
			builder.append("<trainingStartSP>")
					.append(response.getTrainingStartSP())
					.append("</trainingStartSP>\n");
			builder.append("<trainingDestinationSP>")
					.append(response.getTrainingDestinationSP())
					.append("</trainingDestinationSP>\n");
			builder.append("<trainingToLevel>")
					.append(response.getTrainingToLevel())
					.append("</trainingToLevel>\n");
			builder.append("<skillInTraining>")
					.append(response.isSkillInTraining() ? 1 : 0)
					.append("</skillInTraining>\n");

		}

		builder.append("</result>\n");

		convertCloser(request, builder);
		return builder.toString();
	}
}
