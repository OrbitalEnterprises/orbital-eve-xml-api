package enterprises.orbital.impl.evexmlapi.unittest.test.act;

import enterprises.orbital.evexmlapi.act.IAPIKeyInfo;
import enterprises.orbital.evexmlapi.act.IAccountAPI;
import enterprises.orbital.evexmlapi.act.ICharacter;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class AcctAPIKeyInfoConverter extends ResponseConverter {

  public static String convert(IAccountAPI request, IAPIKeyInfo response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);

    builder.append("<result>\n");
    builder.append("<key accessMask=\"").append(response.getAccessMask()).append("\" type=\"").append(response.getType()).append("\" expires=\"")
        .append(toEveDateFormat(response.getExpires())).append("\">\n");
    builder
        .append("<rowset name=\"characters\" key=\"characterID\" columns=\"characterID,characterName,corporationID,corporationName,allianceID,allianceName,factionID,factionName\"");
    if (response.getCharacters().size() == 0) {
      builder.append(" />\n");
    } else {
      builder.append(">\n");
      for (ICharacter nextChar : response.getCharacters()) {
        builder.append("<row characterID=\"").append(nextChar.getCharacterID()).append("\" characterName=\"").append(nextChar.getName())
            .append("\" corporationID=\"").append(nextChar.getCorporationID()).append("\" corporationName=\"").append(nextChar.getCorporationName())
            .append("\" allianceID=\"").append(nextChar.getAllianceID()).append("\" allianceName=\"")
            .append(nextChar.getAllianceName() == null ? "" : nextChar.getAllianceName()).append("\" factionID=\"").append(nextChar.getFactionID())
            .append("\" factionName=\"").append(nextChar.getFactionName()).append("\" />\n");
      }
      builder.append("</rowset>\n");
    }
    builder.append("</key>\n");
    builder.append("</result>\n");

    convertCloser(request, builder);

    return builder.toString();
  }
}
