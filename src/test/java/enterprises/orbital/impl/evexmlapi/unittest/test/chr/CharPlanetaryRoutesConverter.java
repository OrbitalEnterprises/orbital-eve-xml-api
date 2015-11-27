package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.util.Collection;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.IPlanetaryRoute;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharPlanetaryRoutesConverter extends ResponseConverter {

  public static String convert(ICharacterAPI request, Collection<IPlanetaryRoute> response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");

    // Do current medals
    builder
        .append("<rowset name=\"routes\" key=\"routeID\" columns=\"routeID,sourcePinID,destinationPinID,contentTypeID,contentTypeName,quantity,waypoint1,waypoint2,waypoint3,waypoint4,waypoint5\"");
    if (response.size() == 0)
      builder.append(" />\n");
    else {
      builder.append(">\n");

      for (IPlanetaryRoute next : response) {
        // <row contentTypeName="Noble Metals" quantity="3000" waypoint1="0" waypoint2="0" waypoint3="0" waypoint4="0" waypoint5="0" />
        builder.append("<row routeID=\"").append(next.getRouteID());
        builder.append("\" sourcePinID=\"").append(next.getSourcePinID());
        builder.append("\" destinationPinID=\"").append(next.getDestinationPinID());
        builder.append("\" contentTypeID=\"").append(next.getContentTypeID());
        builder.append("\" contentTypeName=\"").append(next.getContentTypeName());
        builder.append("\" quantity=\"").append(next.getQuantity());
        builder.append("\" waypoint1=\"").append(next.getWaypoint1());
        builder.append("\" waypoint2=\"").append(next.getWaypoint2());
        builder.append("\" waypoint3=\"").append(next.getWaypoint3());
        builder.append("\" waypoint4=\"").append(next.getWaypoint4());
        builder.append("\" waypoint5=\"").append(next.getWaypoint5());
        builder.append("\" />\n");
      }

      builder.append("</rowset>\n");
    }

    builder.append("</result>\n");
    convertCloser(request, builder);
    return builder.toString();
  }
}
