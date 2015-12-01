package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.util.Collection;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.shared.ILocation;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharLocationsConverter extends ResponseConverter {

  public static String convert(ICharacterAPI request, Collection<ILocation> response) {
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
        builder.append("\" x=\"").append(CharBookmarksConverter.posConverter(next.getX()));
        builder.append("\" y=\"").append(CharBookmarksConverter.posConverter(next.getY()));
        builder.append("\" z=\"").append(CharBookmarksConverter.posConverter(next.getZ()));
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
