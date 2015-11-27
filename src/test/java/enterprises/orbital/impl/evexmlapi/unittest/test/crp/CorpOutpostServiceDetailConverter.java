package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.util.Collection;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.crp.IOutpostServiceDetail;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CorpOutpostServiceDetailConverter extends ResponseConverter {

  public static String displayDouble(double ref) {
    String val = String.format("%1$.2f", ref);
    if (val.substring(val.indexOf('.')).equals(".00")) { return val.substring(0, val.indexOf('.')); }
    return val;
  }

  public static String convert(ICorporationAPI request, Collection<IOutpostServiceDetail> response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");

    builder
        .append("<rowset name=\"outpostServiceDetails\" key=\"stationID, serviceName\" columns=\"stationID,ownerID,serviceName,minStanding,surchargePerBadStanding,discountPerGoodStanding\"");
    if (response.size() == 0)
      builder.append(" />\n");
    else {
      builder.append(">\n");

      for (IOutpostServiceDetail next : response) {
        builder.append("<row stationID=\"").append(next.getStationID());
        builder.append("\" ownerID=\"").append(next.getOwnerID());
        builder.append("\" serviceName=\"").append(next.getServiceName());
        builder.append("\" minStanding=\"").append(displayDouble(next.getMinStanding()));
        builder.append("\" surchargePerBadStanding=\"").append(displayDouble(next.getSurchargePerBadStanding()));
        builder.append("\" discountPerGoodStanding=\"").append(displayDouble(next.getDiscountPerGoodStanding()));
        builder.append("\" />\n");
      }
      builder.append("</rowset>\n");
    }

    builder.append("</result>\n");
    convertCloser(request, builder);
    return builder.toString();
  }

}
