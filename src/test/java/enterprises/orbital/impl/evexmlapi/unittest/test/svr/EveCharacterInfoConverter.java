package enterprises.orbital.impl.evexmlapi.unittest.test.svr;

import enterprises.orbital.evexmlapi.eve.ICharacterInfo;
import enterprises.orbital.evexmlapi.eve.IEmploymentHistory;
import enterprises.orbital.evexmlapi.eve.IEveAPI;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class EveCharacterInfoConverter extends ResponseConverter {

  public static String convert(IEveAPI request, ICharacterInfo response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");

    builder.append("<characterID>").append(response.getCharacterID()).append("</characterID>\n");
    builder.append("<characterName>").append(response.getCharacterName()).append("</characterName>\n");
    builder.append("<race>").append(response.getRace()).append("</race>\n");
    builder.append("<bloodline>").append(response.getBloodline()).append("</bloodline>\n");
    builder.append("<accountBalance>").append(String.format("%.2f", response.getAccountBalance())).append("</accountBalance>\n");
    builder.append("<skillPoints>").append(response.getSkillPoints()).append("</skillPoints>\n");
    builder.append("<shipName>").append(response.getShipName()).append("</shipName>\n");
    builder.append("<shipTypeID>").append(response.getShipTypeID()).append("</shipTypeID>\n");
    builder.append("<shipTypeName>").append(response.getShipTypeName()).append("</shipTypeName>\n");
    builder.append("<corporationID>").append(response.getCorporationID()).append("</corporationID>\n");
    builder.append("<corporation>").append(response.getCorporation()).append("</corporation>\n");
    builder.append("<corporationDate>").append(toEveDateFormat(response.getCorporationDate())).append("</corporationDate>\n");
    if (response.getAllianceID() > 0) {
      builder.append("<allianceID>").append(response.getAllianceID()).append("</allianceID>\n");
    }
    if (response.getAlliance() != null) {
      builder.append("<alliance>").append(response.getAlliance()).append("</alliance>\n");
    }
    if (response.getAllianceDate() != null) {
      builder.append("<allianceDate>").append(toEveDateFormat(response.getAllianceDate())).append("</allianceDate>\n");
    }
    builder.append("<lastKnownLocation>").append(response.getLastKnownLocation()).append("</lastKnownLocation>\n");
    builder.append("<securityStatus>").append(response.getSecurityStatus()).append("</securityStatus>\n");
    builder.append("<rowset name=\"employmentHistory\" key=\"recordID\" columns=\"recordID,corporationID,startDate\">\n");
    for (IEmploymentHistory h : response.getEmploymentHistory()) {
      builder.append("<row recordID=\"").append(h.getRecordID()).append("\" corporationID=\"").append(h.getCorporationID()).append("\" startDate=\"")
          .append(toEveDateFormat(h.getStartDate())).append("\" />\n");
    }
    builder.append("</rowset>\n");
    builder.append("</result>\n");

    convertCloser(request, builder);
    return builder.toString();
  }
}
