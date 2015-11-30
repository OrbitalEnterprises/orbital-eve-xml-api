package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.util.Collection;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.shared.IContractBid;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharContractBidsConverter extends ResponseConverter {

  public static String convert(ICharacterAPI request, Collection<IContractBid> response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");
    builder.append("<rowset name=\"bidList\" key=\"bidID\" columns=\"bidID,contractID,bidderID,dateBid,amount\"");
    if (response.size() > 0) {
      builder.append(">\n");

      for (IContractBid next : response) {
        builder.append("<row bidID=\"").append(next.getBidID());
        builder.append("\" contractID=\"").append(next.getContractID());
        builder.append("\" bidderID=\"").append(next.getBidderID());
        builder.append("\" dateBid=\"").append(next.getDateBid() != null ? toEveDateFormat(next.getDateBid()) : "");
        builder.append("\" amount=\"").append(String.format("%.2f", next.getAmount()));
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
