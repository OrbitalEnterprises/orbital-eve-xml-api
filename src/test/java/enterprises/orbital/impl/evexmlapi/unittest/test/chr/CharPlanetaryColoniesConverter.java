package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.util.Collection;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.IPlanetaryColony;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharPlanetaryColoniesConverter extends ResponseConverter {

  public static String convert(ICharacterAPI request, Collection<IPlanetaryColony> response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");

    builder
        .append("<rowset name=\"colonies\" key=\"planetID\" columns=\"solarSystemID,solarSystemName,planetID,planetName,planetTypeID,planetTypeName,ownerID,ownerName,lastUpdate,upgradeLevel,numberOfPins\"");
    if (response.size() == 0)
      builder.append(" />\n");
    else {
      builder.append(">\n");

      for (IPlanetaryColony next : response) {
        builder.append("<row solarSystemID=\"").append(next.getSolarSystemID());
        builder.append("\" solarSystemName=\"").append(next.getSolarSystemName());
        builder.append("\" planetID=\"").append(next.getPlanetID());
        builder.append("\" planetName=\"").append(next.getPlanetName());
        builder.append("\" planetTypeID=\"").append(next.getPlanetTypeID());
        builder.append("\" planetTypeName=\"").append(next.getPlanetTypeName());
        builder.append("\" ownerID=\"").append(next.getOwnerID());
        builder.append("\" ownerName=\"").append(next.getOwnerName());
        builder.append("\" lastUpdate=\"").append(toEveDateFormat(next.getLastUpdate()));
        builder.append("\" upgradeLevel=\"").append(next.getUpgradeLevel());
        builder.append("\" numberOfPins=\"").append(next.getNumberOfPins());
        builder.append("\" />\n");
      }

      builder.append("</rowset>\n");
    }

    builder.append("</result>\n");
    convertCloser(request, builder);
    return builder.toString();
  }
}
