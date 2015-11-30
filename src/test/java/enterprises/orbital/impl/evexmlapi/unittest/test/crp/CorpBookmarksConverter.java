package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.util.Collection;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.shared.IBookmark;
import enterprises.orbital.evexmlapi.shared.IBookmarkFolder;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CorpBookmarksConverter extends ResponseConverter {

  public static String posConverter(double pos) {
    if (pos == Math.round(pos)) return String.format("%.0f", pos);
    String val = String.format("%.7f", pos);
    if (!val.contains(".")) return val;
    while (val.charAt(val.length() - 1) == '0') {
      val = val.substring(0, val.length() - 1);
    }
    return val;
  }

  public static String convert(ICorporationAPI request, Collection<IBookmarkFolder> response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");
    builder.append("<rowset name=\"folders\" key=\"folderID\" columns=\"folderName,creatorID\"");
    if (response.size() > 0) {
      builder.append(">\n");
      for (IBookmarkFolder nextFolder : response) {
        builder.append("<row folderID=\"").append(nextFolder.getFolderID());
        builder.append("\" folderName=\"").append(nextFolder.getFolderName());
        builder.append("\" creatorID=\"").append(nextFolder.getCreatorID());
        builder.append("\">\n");
        builder.append("<rowset name=\"bookmarks\" key=\"bookmarkID\" columns=\"creatorID,created,itemID,typeID,locationID,x,y,z,memo,note\"");
        if (nextFolder.getBookmarks().size() > 0) {
          builder.append(">\n");
          for (IBookmark next : nextFolder.getBookmarks()) {
            builder.append("<row bookmarkID=\"").append(next.getBookmarkID());
            builder.append("\" creatorID=\"").append(next.getCreatorID());
            builder.append("\" created=\"").append(toEveDateFormat(next.getCreated()));
            builder.append("\" itemID=\"").append(next.getItemID());
            builder.append("\" typeID=\"").append(next.getTypeID());
            builder.append("\" locationID=\"").append(next.getLocationID());
            builder.append("\" x=\"").append(posConverter(next.getX()));
            builder.append("\" y=\"").append(posConverter(next.getY()));
            builder.append("\" z=\"").append(posConverter(next.getZ()));
            builder.append("\" memo=\"").append(next.getMemo());
            builder.append("\" note=\"").append(next.getNote());
            builder.append("\" />\n");
          }
          builder.append("</rowset>\n");
        } else {
          builder.append(" />\n");
        }
        builder.append("</row>\n");
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
