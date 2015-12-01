package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.util.Collection;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.shared.ILocation;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CorpLocationsConverter extends ResponseConverter {

  public static String convert(ICorporationAPI request, Collection<ILocation> response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");
    builder.append("<rowset name=\"locations\" key=\"itemID\" columns=\"itemID,itemName,x,y,z\"");
    if (response.size() > 0) {
      builder.append(">\n");

      for (ILocation next : response) {
        builder.append("<row itemID=\"");
        builder.append(next.getItemID());
        builder.append("\" itemName=\"");
        builder.append(next.getItemName());
        builder.append("\" x=\"").append(CorpBookmarksConverter.posConverter(next.getX()));
        builder.append("\" y=\"").append(CorpBookmarksConverter.posConverter(next.getY()));
        builder.append("\" z=\"").append(CorpBookmarksConverter.posConverter(next.getZ()));
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
