package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.util.Collection;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.shared.IMarketOrder;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CorpMarketOrdersConverter extends ResponseConverter {

	public static String convert(ICorporationAPI request,
			Collection<IMarketOrder> response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);
		builder.append("<result>\n");

		builder.append("<rowset name=\"orders\" key=\"orderID\" columns=\"orderID,charID,stationID,volEntered,volRemaining,minVolume,orderState,typeID,range,accountKey,duration,escrow,price,bid,issued\"");

		if (response.size() == 0)
			builder.append(" />\n");
		else {
			builder.append(">\n");

			for (IMarketOrder next : response) {
				builder.append("<row orderID=\"").append(next.getOrderID());
				builder.append("\" charID=\"").append(next.getCharID());
				builder.append("\" stationID=\"").append(next.getStationID());
				builder.append("\" volEntered=\"").append(next.getVolEntered());
				builder.append("\" volRemaining=\"").append(
						next.getVolRemaining());
				builder.append("\" minVolume=\"").append(next.getMinVolume());
				builder.append("\" orderState=\"").append(next.getOrderState());
				builder.append("\" typeID=\"").append(next.getTypeID());
				builder.append("\" range=\"").append(next.getRange());
				builder.append("\" accountKey=\"").append(next.getAccountKey());
				builder.append("\" duration=\"").append(next.getDuration());
				builder.append("\" escrow=\"").append(
						String.format("%.2f", next.getEscrow()));
				builder.append("\" price=\"").append(
						String.format("%.2f", next.getPrice()));
				builder.append("\" bid=\"").append(next.getBid());
				builder.append("\" issued=\"").append(
						toEveDateFormat(next.getIssued()));
				builder.append("\" />\n");
			}

			builder.append("</rowset>\n");
		}

		builder.append("</result>\n");
		convertCloser(request, builder);
		return builder.toString();
	}
}
