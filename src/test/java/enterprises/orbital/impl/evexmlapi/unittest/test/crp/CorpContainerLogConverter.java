package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.util.Collection;

import enterprises.orbital.evexmlapi.crp.IContainerLog;
import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CorpContainerLogConverter extends ResponseConverter {

  public static String convert(ICorporationAPI request, Collection<IContainerLog> response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");

    builder
        .append("<rowset name=\"containerLog\" key=\"logTime\" columns=\"logTime,itemID,itemTypeID,actorID,actorName,flag,locationID,action,passwordType,typeID,quantity,oldConfiguration,newConfiguration\"");

    if (response.size() == 0)
      builder.append(" />\n");
    else {
      builder.append(">\n");

      for (IContainerLog next : response) {
        builder.append("<row logTime=\"").append(toEveDateFormat(next.getLogTime()));
        builder.append("\" itemID=\"").append(next.getItemID());
        builder.append("\" itemTypeID=\"").append(next.getItemTypeID());
        builder.append("\" actorID=\"").append(next.getActorID());
        builder.append("\" actorName=\"").append(next.getActorName());
        builder.append("\" flag=\"").append(next.getFlag());
        builder.append("\" locationID=\"").append(next.getLocationID());
        builder.append("\" action=\"").append(next.getAction());
        builder.append("\" passwordType=\"").append(next.getPasswordType());
        builder.append("\" typeID=\"");
        if (next.getTypeID() != 0) builder.append(next.getTypeID());
        builder.append("\" quantity=\"");
        if (next.getQuantity() != 0) builder.append(next.getQuantity());
        builder.append("\" oldConfiguration=\"");
        if (next.getOldConfiguration() != null) builder.append(next.getOldConfiguration());
        builder.append("\" newConfiguration=\"");
        if (next.getNewConfiguration() != null) builder.append(next.getNewConfiguration());
        builder.append("\" />\n");
      }

      builder.append("</rowset>\n");
    }

    builder.append("</result>\n");
    convertCloser(request, builder);
    return builder.toString();
  }
}
