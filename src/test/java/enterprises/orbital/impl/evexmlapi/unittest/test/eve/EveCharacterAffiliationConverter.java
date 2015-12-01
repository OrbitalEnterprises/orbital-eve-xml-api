package enterprises.orbital.impl.evexmlapi.unittest.test.eve;

import java.util.Collection;

import enterprises.orbital.evexmlapi.eve.ICharacterAffiliation;
import enterprises.orbital.evexmlapi.eve.IEveAPI;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class EveCharacterAffiliationConverter extends ResponseConverter {

  public static String convert(IEveAPI request, Collection<ICharacterAffiliation> response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");

    builder
        .append("<rowset name=\"characters\" key=\"characterID\" columns=\"characterName,characterID,corporationName,corporationID,allianceName,allianceID,factionName,factionID\"");
    if (response.size() == 0)
      builder.append(" />\n");
    else {
      builder.append(">\n");
      for (ICharacterAffiliation next : response) {
        builder.append("<row characterID=\"").append(next.getCharacterID());
        builder.append("\" characterName=\"").append(next.getCharacterName());
        builder.append("\" corporationID=\"").append(next.getCorporationID());
        builder.append("\" corporationName=\"").append(next.getCorporationName());
        builder.append("\" allianceID=\"").append(next.getAllianceID());
        builder.append("\" allianceName=\"").append(next.getAllianceName());
        builder.append("\" factionID=\"").append(next.getFactionID());
        builder.append("\" factionName=\"").append(next.getFactionName());
        builder.append("\" />\n");
      }
      builder.append("</rowset>\n");
    }

    builder.append("</result>\n");

    convertCloser(request, builder);
    return builder.toString();
  }
}
