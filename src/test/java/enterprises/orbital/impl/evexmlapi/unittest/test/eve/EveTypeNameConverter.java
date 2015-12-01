package enterprises.orbital.impl.evexmlapi.unittest.test.eve;

import java.util.Collection;

import enterprises.orbital.evexmlapi.eve.IEveAPI;
import enterprises.orbital.evexmlapi.eve.ITypeName;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class EveTypeNameConverter extends ResponseConverter {

  public static String convert(IEveAPI request, Collection<ITypeName> response) {
    StringBuilder builder = new StringBuilder();

    convertOpener(request, builder);
    builder.append("<result>\n");

    builder.append("<rowset name=\"types\" key=\"typeID\" columns=\"typeID,typeName\"");
    if (response.size() == 0)
      builder.append(" />\n");
    else {
      builder.append(">\n");
      for (ITypeName next : response) {
        builder.append("<row typeID=\"").append(next.getTypeID());
        builder.append("\" typeName=\"").append(next.getTypeName());
        builder.append("\" />\n");
      }
      builder.append("</rowset>\n");
    }

    builder.append("</result>\n");

    convertCloser(request, builder);
    return builder.toString();
  }
}
