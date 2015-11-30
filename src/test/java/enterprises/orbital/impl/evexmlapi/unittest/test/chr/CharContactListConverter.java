package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.util.List;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.shared.IContact;
import enterprises.orbital.evexmlapi.shared.IContactLabel;
import enterprises.orbital.evexmlapi.shared.IContactSet;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharContactListConverter extends ResponseConverter {

  public static String convert(ICharacterAPI request, IContactSet response) {
    StringBuilder builder = new StringBuilder();

    // Extract lists and labels
    List<IContact> charContacts = response.getContacts();
    List<IContact> corpContacts = response.getCorporateContacts();
    List<IContact> allianceContacts = response.getAllianceContacts();
    List<IContactLabel> charLabels = response.getContactLabels();
    List<IContactLabel> corpLabels = response.getCorporateContactLabels();
    List<IContactLabel> allianceLabels = response.getAllianceContactLabels();

    convertOpener(request, builder);
    builder.append("<result");
    if (charContacts.size() == 0 && corpContacts.size() == 0 && allianceContacts.size() == 0 && charLabels.size() == 0 && corpLabels.size() == 0
        && allianceLabels.size() == 0)
      builder.append(" />\n");
    else {
      builder.append(">\n");

      builder.append("<rowset name=\"contactList\" key=\"contactID\" columns=\"contactID,contactName,standing,contactTypeID,labelMask,inWatchlist\"");
      if (charContacts.size() > 0) {
        builder.append(">\n");

        for (IContact next : charContacts) {
          builder.append("<row contactID=\"").append(next.getContactID());
          builder.append("\" contactName=\"").append(next.getContactName());
          builder.append("\" standing=\"");
          if (next.getStanding() == (int) next.getStanding())
            builder.append((int) next.getStanding());
          else
            builder.append(next.getStanding());
          builder.append("\" contactTypeID=\"").append(next.getContactTypeID());
          builder.append("\" labelMask=\"").append(next.getLabelMask());
          builder.append("\" inWatchlist=\"").append(next.isInWatchlist() ? "True" : "False");
          builder.append("\" />\n");
        }
        builder.append("</rowset>\n");

      } else {
        builder.append(" />\n");
      }

      builder.append("<rowset name=\"contactLabels\" key=\"labelID\" columns=\"name\"");
      if (charLabels.size() > 0) {
        builder.append(">\n");

        for (IContactLabel next : charLabels) {
          builder.append("<row labelID=\"").append(next.getLabelID());
          builder.append("\" name=\"").append(next.getName());
          builder.append("\" />\n");
        }
        builder.append("</rowset>\n");

      } else {
        builder.append(" />\n");
      }

      builder.append("<rowset name=\"corporateContactList\" key=\"contactID\" columns=\"contactID,contactName,standing,contactTypeID,labelMask\"");
      if (corpContacts.size() > 0) {
        builder.append(">\n");

        for (IContact next : corpContacts) {
          builder.append("<row contactID=\"").append(next.getContactID());
          builder.append("\" contactName=\"").append(next.getContactName());
          builder.append("\" standing=\"");
          if (next.getStanding() == (int) next.getStanding())
            builder.append((int) next.getStanding());
          else
            builder.append(next.getStanding());
          builder.append("\" contactTypeID=\"").append(next.getContactTypeID());
          builder.append("\" labelMask=\"").append(next.getLabelMask());
          builder.append("\" />\n");
        }
        builder.append("</rowset>\n");

      } else {
        builder.append(" />\n");
      }

      builder.append("<rowset name=\"corporateContactLabels\" key=\"labelID\" columns=\"name\"");
      if (corpLabels.size() > 0) {
        builder.append(">\n");

        for (IContactLabel next : corpLabels) {
          builder.append("<row labelID=\"").append(next.getLabelID());
          builder.append("\" name=\"").append(next.getName());
          builder.append("\" />\n");
        }
        builder.append("</rowset>\n");

      } else {
        builder.append(" />\n");
      }

      builder.append("<rowset name=\"allianceContactList\" key=\"contactID\" columns=\"contactID,contactName,standing,contactTypeID,labelMask\"");
      if (allianceContacts.size() > 0) {
        builder.append(">\n");

        for (IContact next : allianceContacts) {
          builder.append("<row contactID=\"").append(next.getContactID());
          builder.append("\" contactName=\"").append(next.getContactName());
          builder.append("\" standing=\"");
          if (next.getStanding() == (int) next.getStanding())
            builder.append((int) next.getStanding());
          else
            builder.append(next.getStanding());
          builder.append("\" contactTypeID=\"").append(next.getContactTypeID());
          builder.append("\" labelMask=\"").append(next.getLabelMask());
          builder.append("\" />\n");
        }
        builder.append("</rowset>\n");

      } else {
        builder.append(" />\n");
      }

      builder.append("<rowset name=\"allianceContactLabels\" key=\"labelID\" columns=\"name\"");
      if (allianceLabels.size() > 0) {
        builder.append(">\n");

        for (IContactLabel next : allianceLabels) {
          builder.append("<row labelID=\"").append(next.getLabelID());
          builder.append("\" name=\"").append(next.getName());
          builder.append("\" />\n");
        }
        builder.append("</rowset>\n");

      } else {
        builder.append(" />\n");
      }

      builder.append("</result>\n");
    }

    convertCloser(request, builder);
    return builder.toString();
  }
}
