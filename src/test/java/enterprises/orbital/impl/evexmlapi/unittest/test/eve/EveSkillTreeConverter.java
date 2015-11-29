package enterprises.orbital.impl.evexmlapi.unittest.test.eve;

import java.util.Collection;

import enterprises.orbital.evexmlapi.eve.IBonus;
import enterprises.orbital.evexmlapi.eve.IEveAPI;
import enterprises.orbital.evexmlapi.eve.IRequiredSkill;
import enterprises.orbital.evexmlapi.eve.ISkillGroup;
import enterprises.orbital.evexmlapi.eve.ISkillMember;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class EveSkillTreeConverter extends ResponseConverter {

	public static String convert(IEveAPI request,
			Collection<ISkillGroup> response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);
		builder.append("<result>\n");

		builder.append("<rowset name=\"skillGroups\" key=\"groupID\" columns=\"groupName,groupID\"");
		if (response.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");

			for (ISkillGroup nextGroup : response) {
				builder.append("<row groupName=\"").append(
						nextGroup.getGroupName());
				builder.append("\" groupID=\"").append(nextGroup.getGroupID());
				builder.append("\" >\n");

				builder.append("<rowset name=\"skills\" key=\"typeID\" columns=\"typeName,groupID,typeID,published\"");
				if (nextGroup.getSkills().size() == 0)
					builder.append(" />\n");
				else {
					builder.append(">\n");

					for (ISkillMember nextMember : nextGroup.getSkills()) {
						builder.append("<row typeName=\"").append(
								nextMember.getTypeName());
						builder.append("\" groupID=\"").append(
								nextMember.getGroupID());
						builder.append("\" typeID=\"").append(
								nextMember.getTypeID());
						builder.append("\" published=\"").append(
								nextMember.isPublished() ? 1 : 0);
						builder.append("\" >\n");

						builder.append("<description>");
						String des = nextMember.getDescription();
						des = des.replace("<", "&lt;");
						des = des.replace(">", "&gt;");
						builder.append(des);
						builder.append("</description>\n");
						builder.append("<rank>");
						builder.append(nextMember.getRank());
						builder.append("</rank>\n");

						builder.append("<rowset name=\"requiredSkills\" key=\"typeID\" columns=\"typeID,skillLevel\"");
						if (nextMember.getRequiredSkills().size() == 0)
							builder.append(" />\n");
						else {
							builder.append(">\n");

							for (IRequiredSkill nextReqSkill : nextMember
									.getRequiredSkills()) {
								builder.append("<row typeID=\"").append(
										nextReqSkill.getTypeID());
								builder.append("\" skillLevel=\"").append(
										nextReqSkill.getLevel());
								builder.append("\" />\n");
							}

							builder.append("</rowset>\n");
						}

						String primAttr = nextMember
								.getRequiredPrimaryAttribute();
						String secAttr = nextMember
								.getRequiredSecondaryAttribute();

						if ((primAttr == null) && (secAttr == null))
							builder.append("<requiredAttributes/>\n");
						else {
							builder.append("<requiredAttributes>\n");
							if (secAttr != null) {
								builder.append("<secondaryAttribute>");
								builder.append(secAttr);
								builder.append("</secondaryAttribute>\n");
							}
							if (primAttr != null) {
								builder.append("<primaryAttribute>");
								builder.append(primAttr);
								builder.append("</primaryAttribute>\n");
							}
							builder.append("</requiredAttributes>\n");
						}

						builder.append("<rowset name=\"skillBonusCollection\" key=\"bonusType\" columns=\"bonusType,bonusValue\"");
						if (nextMember.getBonuses().size() == 0)
							builder.append(" />\n");
						else {
							builder.append(">\n");

							for (IBonus nextBonus : nextMember.getBonuses()) {
								builder.append("<row bonusType=\"").append(
										nextBonus.getBonusType());
								builder.append("\" bonusValue=\"").append(
										nextBonus.getBonusValue());
								builder.append("\" />\n");
							}

							builder.append("</rowset>\n");
						}

						builder.append("</row>\n");
					}

					builder.append("</rowset>\n");

				}

				builder.append("</row>\n");
			}

			builder.append("</rowset>\n");
		}

		builder.append("</result>\n");

		convertCloser(request, builder);
		return builder.toString();
	}
}
