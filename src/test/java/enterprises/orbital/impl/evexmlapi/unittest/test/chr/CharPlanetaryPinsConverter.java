package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.util.Collection;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.IPlanetaryPin;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharPlanetaryPinsConverter extends ResponseConverter {

  public static String convert(ICharacterAPI request, Collection<IPlanetaryPin> response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");

    // Do current medals
    builder
        .append("<rowset name=\"pins\" key=\"pinID\" columns=\"pinID,typeID,typeName,schematicID,lastLaunchTime,cycleTime,quantityPerCycle,installTime,expiryTime,contentTypeID,contentTypeName,contentQuantity,longitude,latitude\"");
    if (response.size() == 0)
      builder.append(" />\n");
    else {
      builder.append(">\n");

      for (IPlanetaryPin next : response) {
        builder.append("<row pinID=\"").append(next.getPinID());
        builder.append("\" typeID=\"").append(next.getTypeID());
        builder.append("\" typeName=\"").append(next.getTypeName());
        builder.append("\" schematicID=\"").append(next.getSchematicID());
        builder.append("\" lastLaunchTime=\"").append(toEveDateFormat(next.getLastLaunchTime()));
        builder.append("\" cycleTime=\"").append(next.getCycleTime());
        builder.append("\" quantityPerCycle=\"").append(next.getQuantityPerCycle());
        builder.append("\" installTime=\"").append(toEveDateFormat(next.getInstallTime()));
        builder.append("\" expiryTime=\"").append(toEveDateFormat(next.getExpiryTime()));
        builder.append("\" contentTypeID=\"").append(next.getContentTypeID());
        builder.append("\" contentTypeName=\"").append(next.getContentTypeName());
        builder.append("\" contentQuantity=\"").append(next.getContentQuantity());
        builder.append("\" longitude=\"").append(next.getLongitude());
        builder.append("\" latitude=\"").append(next.getLatitude());
        builder.append("\" />\n");
      }

      builder.append("</rowset>\n");
    }

    builder.append("</result>\n");
    convertCloser(request, builder);
    return builder.toString();
  }
}
