package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.util.Collection;

import org.apache.commons.lang3.StringEscapeUtils;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.IChatChannel;
import enterprises.orbital.evexmlapi.chr.IChatChannelMember;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharChatChannelsConverter extends ResponseConverter {

  public static String posConverter(double pos) {
    if (pos == Math.round(pos)) return String.format("%.0f", pos);
    String val = String.format("%.7f", pos);
    if (!val.contains(".")) return val;
    while (val.charAt(val.length() - 1) == '0') {
      val = val.substring(0, val.length() - 1);
    }
    return val;
  }

  public static String convert(ICharacterAPI request, Collection<IChatChannel> response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");
    builder.append("<rowset name=\"channels\" key=\"channelID\" columns=\"ownerID,ownerName,displayName,comparisonKey,hasPassword,motd\"");
    if (response.size() > 0) {
      builder.append(">\n");
      for (IChatChannel nextChannel : response) {
        builder.append("<row channelID=\"").append(nextChannel.getChannelID());
        builder.append("\" ownerID=\"").append(nextChannel.getOwnerID());
        builder.append("\" ownerName=\"").append(nextChannel.getOwnerName());
        builder.append("\" displayName=\"").append(nextChannel.getDisplayName());
        builder.append("\" comparisonKey=\"").append(nextChannel.getComparisonKey());
        builder.append("\" hasPassword=\"").append(nextChannel.hasPassword());
        builder.append("\" motd=\"").append(StringEscapeUtils.escapeXml10(nextChannel.getMOTD()));
        builder.append("\">\n");
        builder.append("<rowset name=\"allowed\" key=\"accessorID\" columns=\"accessorName\"");
        if (nextChannel.getAllowed().size() > 0) {
          builder.append(">\n");
          for (IChatChannelMember next : nextChannel.getAllowed()) {
            builder.append("<row accessorID=\"").append(next.getAccessorID());
            builder.append("\" accessorName=\"").append(next.getAccessorName());
            builder.append("\" />\n");
          }
          builder.append("</rowset>\n");
        } else {
          builder.append(" />\n");
        }
        builder.append("<rowset name=\"blocked\" key=\"accessorID\" columns=\"accessorName,untilWhen,reason\"");
        if (nextChannel.getBlocked().size() > 0) {
          builder.append(">\n");
          for (IChatChannelMember next : nextChannel.getBlocked()) {
            builder.append("<row accessorID=\"").append(next.getAccessorID());
            builder.append("\" accessorName=\"").append(next.getAccessorName());
            builder.append("\" untilWhen=\"").append(toEveDateFormat(next.getUntilWhen()));
            builder.append("\" reason=\"").append(next.getReason());
            builder.append("\" />\n");
          }
          builder.append("</rowset>\n");
        } else {
          builder.append(" />\n");
        }
        builder.append("<rowset name=\"muted\" key=\"accessorID\" columns=\"accessorName,untilWhen,reason\"");
        if (nextChannel.getMuted().size() > 0) {
          builder.append(">\n");
          for (IChatChannelMember next : nextChannel.getMuted()) {
            builder.append("<row accessorID=\"").append(next.getAccessorID());
            builder.append("\" accessorName=\"").append(next.getAccessorName());
            builder.append("\" untilWhen=\"").append(toEveDateFormat(next.getUntilWhen()));
            builder.append("\" reason=\"").append(next.getReason());
            builder.append("\" />\n");
          }
          builder.append("</rowset>\n");
        } else {
          builder.append(" />\n");
        }
        builder.append("<rowset name=\"operators\" key=\"accessorID\" columns=\"accessorName\"");
        if (nextChannel.getOperators().size() > 0) {
          builder.append(">\n");
          for (IChatChannelMember next : nextChannel.getOperators()) {
            builder.append("<row accessorID=\"").append(next.getAccessorID());
            builder.append("\" accessorName=\"").append(next.getAccessorName());
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
