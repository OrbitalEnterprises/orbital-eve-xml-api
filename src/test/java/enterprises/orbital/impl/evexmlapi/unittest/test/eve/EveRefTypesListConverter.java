package enterprises.orbital.impl.evexmlapi.unittest.test.eve;

import java.util.Collection;

import enterprises.orbital.evexmlapi.eve.IEveAPI;
import enterprises.orbital.evexmlapi.eve.IRefType;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class EveRefTypesListConverter extends ResponseConverter {

	public static String convert(IEveAPI request,
			Collection<IRefType> response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);
		builder.append("<result>\n");

		builder.append("<rowset name=\"refTypes\" key=\"refTypeID\" columns=\"refTypeID,refTypeName\"");
		if (response.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");
			for (IRefType next : response) {
				builder.append("<row refTypeID=\"").append(next.getRefTypeID());
				builder.append("\" refTypeName=\"").append(
						next.getRefTypeName());
				builder.append("\" />\n");
			}
			builder.append("</rowset>\n");
		}

		builder.append("</result>\n");

		convertCloser(request, builder);
		return builder.toString();
	}
}
