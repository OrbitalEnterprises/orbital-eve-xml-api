package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.util.Arrays;
import java.util.Collection;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.IMailMessage;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharMailMessagesConverter extends ResponseConverter {

  public static String convert(ICharacterAPI request, Collection<IMailMessage> response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");

    builder
        .append("<rowset name=\"messages\" key=\"messageID\" columns=\"messageID,senderID,senderName,sentDate,title,toCorpOrAllianceID,toCharacterIDs,toListID\"");

    if (response.size() == 0)
      builder.append(" />\n");
    else {
      builder.append(">\n");

      for (IMailMessage next : response) {

        builder.append("<row messageID=\"").append(next.getMessageID());
        builder.append("\" senderID=\"").append(next.getSenderID());
        builder.append("\" senderName=\"").append(next.getSenderName());
        builder.append("\" sentDate=\"").append(toEveDateFormat(next.getSentDate()));
        builder.append("\" title=\"").append(next.getTitle());
        builder.append("\" toCorpOrAllianceID=\"").append(next.getToCorpOrAllianceID() == 0 ? "" : next.getToCorpOrAllianceID());
        builder.append("\" toCharacterIDs=\"");
        long[] ids = next.getToCharacterIDs();
        if (ids.length != 0) builder.append(Arrays.toString(ids).replace("[", "").replace("]", "").replace(" ", ""));
        builder.append("\" toListID=\"");
        ids = next.getToListID();
        if (ids.length != 0) builder.append(Arrays.toString(ids).replace("[", "").replace("]", "").replace(" ", ""));
        builder.append("\" senderTypeID=\"").append(next.getSenderTypeID());
        builder.append("\" />\n");
      }

      builder.append("</rowset>\n");
    }

    builder.append("</result>\n");
    convertCloser(request, builder);
    return builder.toString();
  }
}
