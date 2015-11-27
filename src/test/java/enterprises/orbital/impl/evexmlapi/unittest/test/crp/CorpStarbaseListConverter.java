package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.util.Collection;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.crp.IStarbase;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CorpStarbaseListConverter extends ResponseConverter {

	public static String convert(ICorporationAPI request,
			Collection<IStarbase> response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);
		builder.append("<result>\n");

		builder.append("<rowset name=\"starbases\" key=\"itemID\" columns=\"itemID,typeID,locationID,moonID,state,stateTimestamp,onlineTimestamp,standingOwnerID\"");
		if (response.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");

			for (IStarbase next : response) {
				builder.append("<row itemID=\"").append(next.getItemID());
				builder.append("\" typeID=\"").append(next.getTypeID());
				builder.append("\" locationID=\"").append(next.getLocationID());
				builder.append("\" moonID=\"").append(next.getMoonID());
				builder.append("\" state=\"").append(next.getState());
				builder.append("\" stateTimestamp=\"").append(
						toEveDateFormat(next.getStateTimestamp()));
				builder.append("\" onlineTimestamp=\"").append(
						toEveDateFormat(next.getOnlineTimestamp()));
				builder.append("\" standingOwnerID=\"").append(
						next.getStandingOwnerID());
				builder.append("\" />\n");
			}
			builder.append("</rowset>\n");
		}

		builder.append("</result>\n");
		convertCloser(request, builder);
		return builder.toString();
	}

}
