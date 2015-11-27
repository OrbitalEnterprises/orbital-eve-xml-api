package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.util.Collection;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.crp.IMemberTracking;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CorpMemberTrackingConverter extends ResponseConverter {

  public static String convert(ICorporationAPI request, Collection<IMemberTracking> response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");

    builder
        .append("<rowset name=\"members\" key=\"characterID\" columns=\"characterID,name,startDateTime,baseID,base,title,logonDateTime,logoffDateTime,locationID,location,shipTypeID,shipType,roles,grantableRoles\"");
    if (response.size() == 0)
      builder.append(" />\n");
    else {
      builder.append(">\n");

      for (IMemberTracking next : response) {
        builder.append("<row characterID=\"").append(next.getCharacterID());
        builder.append("\" name=\"").append(next.getName());
        builder.append("\" startDateTime=\"").append(toEveDateFormat(next.getStartDateTime()));
        builder.append("\" baseID=\"").append(next.getBaseID());
        builder.append("\" base=\"").append(next.getBase() == null ? "" : next.getBase());
        builder.append("\" title=\"").append(next.getTitle() == null ? "" : next.getTitle());
        builder.append("\" logonDateTime=\"").append(toEveDateFormat(next.getLogonDateTime()));
        builder.append("\" logoffDateTime=\"").append(toEveDateFormat(next.getLogoffDateTime()));
        builder.append("\" locationID=\"").append(next.getLocationID());
        builder.append("\" location=\"").append(next.getLocation());
        builder.append("\" shipTypeID=\"").append(next.getShipTypeID());
        builder.append("\" shipType=\"").append(next.getShipType());
        builder.append("\" roles=\"").append(next.getRoles());
        builder.append("\" grantableRoles=\"").append(next.getGrantableRoles());
        builder.append("\" />\n");
      }

      builder.append("</rowset>\n");
    }

    builder.append("</result>\n");
    convertCloser(request, builder);
    return builder.toString();
  }

}
