package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.util.Collection;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.shared.IContractItem;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharContractItemsConverter extends ResponseConverter {

  public static String convert(ICharacterAPI request, Collection<IContractItem> response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");
    builder.append("<rowset name=\"itemList\" key=\"recordID\" columns=\"recordID,typeID,quantity,rawQuantity,singleton,included\"");
    if (response.size() > 0) {
      builder.append(">\n");

      for (IContractItem next : response) {
        builder.append("<row recordID=\"").append(next.getRecordID());
        builder.append("\" typeID=\"").append(next.getTypeID());
        builder.append("\" quantity=\"").append(next.getQuantity());
        builder.append("\" singleton=\"").append(next.isSingleton() ? 1 : 0);
        builder.append("\" included=\"").append(next.isIncluded() ? 1 : 0);
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
