package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.util.Collection;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.shared.IWalletJournalEntry;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CorpWalletJournalConverter extends ResponseConverter {

  public static String convert(
                               ICorporationAPI request,
                               Collection<IWalletJournalEntry> response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");

    builder
        .append("<rowset name=\"entries\" key=\"refID\" columns=\"date,refID,refTypeID,ownerName1,ownerID1,ownerName2,ownerID2,argName1,argID1,amount,balance,reason,owner1TypeID,owner2TypeID\"");

    if (response.size() == 0)
      builder.append(" />\n");
    else {
      builder.append(">\n");

      for (IWalletJournalEntry next : response) {

        builder.append("<row date=\"").append(toEveDateFormat(next.getDate()));
        builder.append("\" refID=\"").append(next.getRefID());
        builder.append("\" refTypeID=\"").append(next.getRefTypeID());
        builder.append("\" ownerName1=\"").append(next.getOwnerName1());
        builder.append("\" ownerID1=\"").append(next.getOwnerID1());
        builder.append("\" ownerName2=\"").append(next.getOwnerName2());
        builder.append("\" ownerID2=\"").append(next.getOwnerID2());
        builder.append("\" argName1=\"").append(next.getArgName1());
        builder.append("\" argID1=\"").append(next.getArgID1());
        builder.append("\" amount=\"").append(String.format("%.2f", next.getAmount()));
        builder.append("\" balance=\"").append(String.format("%.2f", next.getBalance()));
        builder.append("\" reason=\"").append(next.getReason().replace("\n", "&#xA;"));
        builder.append("\" owner1TypeID=\"").append(next.getOwner1TypeID());
        builder.append("\" owner2TypeID=\"").append(next.getOwner2TypeID());
        builder.append("\" />\n");
      }

      builder.append("</rowset>\n");
    }

    builder.append("</result>\n");
    convertCloser(request, builder);
    return builder.toString();
  }
}
