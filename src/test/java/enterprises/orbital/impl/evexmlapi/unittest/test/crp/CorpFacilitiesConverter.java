package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.util.Collection;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.crp.IFacility;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CorpFacilitiesConverter extends ResponseConverter {

  public static String convert(ICorporationAPI request, Collection<IFacility> response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");

    builder
        .append("<rowset name=\"facilities\" key=\"facilityID\" columns=\"facilityID,typeID,typeName,solarSystemID,solarSystemName,regionID,regionName,starbaseModifier,tax\"");
    if (response.size() == 0)
      builder.append(" />\n");
    else {
      builder.append(">\n");

      for (IFacility next : response) {
        builder.append("<row facilityID=\"").append(next.getFacilityID());
        builder.append("\" typeID=\"").append(next.getTypeID());
        builder.append("\" typeName=\"").append(next.getTypeName());
        builder.append("\" solarSystemID=\"").append(next.getSolarSystemID());
        builder.append("\" solarSystemName=\"").append(next.getSolarSystemName());
        builder.append("\" regionID=\"").append(next.getRegionID());
        builder.append("\" regionName=\"").append(next.getRegionName());
        builder.append("\" starbaseModifier=\"").append(next.getStarbaseModifier());
        builder.append("\" tax=\"").append(next.getTax() == 0.0 ? "0" : String.valueOf(next.getTax()));
        builder.append("\" />\n");
      }

      builder.append("</rowset>\n");
    }

    builder.append("</result>\n");
    convertCloser(request, builder);
    return builder.toString();
  }

}
