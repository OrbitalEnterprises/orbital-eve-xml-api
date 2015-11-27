package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.util.Collection;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.IPlanetaryLink;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharPlanetaryLinksConverter extends ResponseConverter {

  public static String convert(ICharacterAPI request, Collection<IPlanetaryLink> response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");

    // Do current medals
    builder.append("<rowset name=\"links\" key=\"sourcePinID\" columns=\"sourcePinID,destinationPinID,linkLevel\"");
    if (response.size() == 0)
      builder.append(" />\n");
    else {
      builder.append(">\n");

      for (IPlanetaryLink next : response) {
        builder.append("<row sourcePinID=\"").append(next.getSourcePinID());
        builder.append("\" destinationPinID=\"").append(next.getDestinationPinID());
        builder.append("\" linkLevel=\"").append(next.getLinkLevel());
        builder.append("\" />\n");
      }

      builder.append("</rowset>\n");
    }

    builder.append("</result>\n");
    convertCloser(request, builder);
    return builder.toString();
  }
}
