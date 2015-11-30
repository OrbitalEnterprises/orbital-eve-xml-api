package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.util.Collection;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.crp.IOutpost;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CorpOutpostListConverter extends ResponseConverter {

  public static String displayDouble(double ref) {
    String val = String.format("%1$.2f", ref);
    if (val.substring(val.indexOf('.')).equals(".00")) { return val.substring(0, val.indexOf('.')); }
    return val;
  }

  public static String convert(ICorporationAPI request, Collection<IOutpost> response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");

    builder.append("<rowset name=\"corporationStarbases\" key=\"stationID\" columns=\"stationID,ownerID,stationName,"
        + "solarSystemID,dockingCostPerShipVolume,officeRentalCost,stationTypeID,reprocessingEfficiency,reprocessingStationTake,standingOwnerID,x,y,z\"");
    if (response.size() == 0)
      builder.append(" />\n");
    else {
      builder.append(">\n");

      for (IOutpost next : response) {
        builder.append("<row stationID=\"").append(next.getStationID());
        builder.append("\" ownerID=\"").append(next.getOwnerID());
        builder.append("\" stationName=\"").append(next.getStationName());
        builder.append("\" solarSystemID=\"").append(next.getSolarSystemID());
        builder.append("\" dockingCostPerShipVolume=\"").append(displayDouble(next.getDockingCostPerShipVolume()));
        builder.append("\" officeRentalCost=\"").append(displayDouble(next.getOfficeRentalCost()));
        builder.append("\" stationTypeID=\"").append(next.getStationTypeID());
        builder.append("\" reprocessingEfficiency=\"").append(next.getReprocessingEfficiency());
        builder.append("\" reprocessingStationTake=\"").append(next.getReprocessingStationTake());
        builder.append("\" standingOwnerID=\"").append(next.getStandingOwnerID());
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
