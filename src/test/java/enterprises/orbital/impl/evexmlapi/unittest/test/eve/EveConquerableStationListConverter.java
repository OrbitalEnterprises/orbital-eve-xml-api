package enterprises.orbital.impl.evexmlapi.unittest.test.eve;

import java.util.Collection;

import enterprises.orbital.evexmlapi.eve.IConquerableStation;
import enterprises.orbital.evexmlapi.eve.IEveAPI;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class EveConquerableStationListConverter extends ResponseConverter {

  public static String convert(IEveAPI request, Collection<IConquerableStation> response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");

    builder
        .append("<rowset name=\"outposts\" key=\"stationID\" columns=\"stationID,stationName,stationTypeID,solarSystemID,corporationID,corporationName,x,y,z\"");
    if (response.size() == 0)
      builder.append(" />\n");
    else {
      builder.append(">\n");
      for (IConquerableStation next : response) {
        builder.append("<row stationID=\"").append(next.getStationID());
        builder.append("\" stationName=\"").append(next.getStationName());
        builder.append("\" stationTypeID=\"").append(next.getStationTypeID());
        builder.append("\" solarSystemID=\"").append(next.getSolarSystemID());
        builder.append("\" corporationID=\"").append(next.getCorporationID());
        builder.append("\" corporationName=\"").append(next.getCorporationName());
        builder.append("\" x=\"").append(next.getX());
        builder.append("\" y=\"").append(next.getY());
        builder.append("\" z=\"").append(next.getZ());
        builder.append("\" />\n");
      }
      builder.append("</rowset>\n");
    }

    builder.append("</result>\n");

    convertCloser(request, builder);
    return builder.toString();
  }
}
