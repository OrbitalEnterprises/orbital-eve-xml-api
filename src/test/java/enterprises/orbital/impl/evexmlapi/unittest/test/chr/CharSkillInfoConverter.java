package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.ISkill;
import enterprises.orbital.evexmlapi.chr.ISkillInfo;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharSkillInfoConverter extends ResponseConverter {

  public static String convert(
                               ICharacterAPI request,
                               ISkillInfo response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");

    builder.append("<freeSkillPoints>").append(response.getFreeSkillPoints()).append("</freeSkillPoints>\n");

    builder.append("<rowset name=\"skills\" key=\"typeID\" columns=\"typeID,skillpoints,level,published\">\n");
    for (ISkill nextSkill : response.getSkills()) {
      builder.append("<row typeID=\"").append(nextSkill.getTypeID());
      builder.append("\" skillpoints=\"").append(nextSkill.getSkillpoints());
      builder.append("\" level=\"").append(nextSkill.getLevel());
      builder.append("\" published=\"").append(nextSkill.isPublished() ? 1 : 0).append("\" />\n");
    }
    builder.append("</rowset>\n");

    builder.append("</result>\n");

    convertCloser(request, builder);
    return builder.toString();
  }
}
