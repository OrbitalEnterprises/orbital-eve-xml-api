package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.util.Collection;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.shared.IBlueprint;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CorpBlueprintsConverter extends ResponseConverter {

  public static String convert(ICorporationAPI request, Collection<IBlueprint> response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");
    builder
        .append("<rowset name=\"blueprints\" key=\"itemID\" columns=\"itemID,locationID,typeID,typeName,flagID,quantity,timeEfficiency,materialEfficiency,runs\"");
    if (response.size() > 0) {
      builder.append(">\n");

      for (IBlueprint next : response) {
        builder.append("<row itemID=\"").append(next.getItemID());
        builder.append("\" locationID=\"").append(next.getLocationID());
        builder.append("\" typeID=\"").append(next.getTypeID());
        builder.append("\" typeName=\"").append(next.getTypeName());
        builder.append("\" flagID=\"").append(next.getFlagID());
        builder.append("\" quantity=\"").append(next.getQuantity());
        builder.append("\" timeEfficiency=\"").append(next.getTimeEfficiency());
        builder.append("\" materialEfficiency=\"").append(next.getMaterialEfficiency());
        builder.append("\" runs=\"").append(next.getRuns());
        builder.append("\" />\n");
      }
      builder.append("</rowset>\n");

    } else {
      builder.append(" />\n");
    }

    builder.append("</result>\n");
    convertCloser(request, builder);
    return builder.toString();
  }
}
