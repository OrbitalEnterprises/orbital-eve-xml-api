package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.crp.ICorporationSheet;
import enterprises.orbital.evexmlapi.crp.IDivision;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CorpCorporationSheetConverter extends ResponseConverter {

	public static String convert(ICorporationAPI req,
			ICorporationSheet obj) {
		StringBuilder builder = new StringBuilder();

		convertOpener(req, builder);
		builder.append("<result>\n");
		builder.append("<corporationID>").append(obj.getCorporationID())
				.append("</corporationID>\n");
		builder.append("<corporationName>").append(obj.getCorporationName())
				.append("</corporationName>\n");
		builder.append("<ticker>").append(obj.getTicker())
				.append("</ticker>\n");
		builder.append("<ceoID>").append(obj.getCeoID()).append("</ceoID>\n");
		builder.append("<ceoName>").append(obj.getCeoName())
				.append("</ceoName>\n");
		builder.append("<stationID>").append(obj.getStationID())
				.append("</stationID>\n");
		builder.append("<stationName>").append(obj.getStationName())
				.append("</stationName>\n");
		builder.append("<description>").append(obj.getDescription())
				.append("</description>\n");
		builder.append("<url>").append(obj.getUrl()).append("</url>\n");
		builder.append("<allianceID>").append(obj.getAllianceID())
				.append("</allianceID>\n");

		builder.append("<taxRate>");
		if (obj.getTaxRate() == (int) obj.getTaxRate())
			builder.append((int) obj.getTaxRate());
		else
			builder.append(obj.getTaxRate());
		builder.append("</taxRate>\n");

		builder.append("<memberCount>").append(obj.getMemberCount())
				.append("</memberCount>\n");
		builder.append("<memberLimit>").append(obj.getMemberLimit())
				.append("</memberLimit>\n");
		builder.append("<shares>").append(obj.getShares())
				.append("</shares>\n");

		builder.append("<rowset name=\"divisions\" key=\"accountKey\" columns=\"accountKey,description\">\n");
		for (IDivision next : obj.getDivisions()) {
			builder.append("<row accountKey=\"").append(next.getAccountKey());
			builder.append("\" description=\"").append(next.getDescription());
			builder.append("\" />\n");
		}
		builder.append("</rowset>\n");

		builder.append("<rowset name=\"walletDivisions\" key=\"accountKey\" columns=\"accountKey,description\">\n");
		for (IDivision next : obj.getWalletDivisions()) {
			builder.append("<row accountKey=\"").append(next.getAccountKey());
			builder.append("\" description=\"").append(next.getDescription());
			builder.append("\" />\n");
		}
		builder.append("</rowset>\n");

		builder.append("<logo>\n");
		builder.append("<graphicID>").append(obj.getLogoGraphicID())
				.append("</graphicID>\n");
		builder.append("<shape1>").append(obj.getLogoShape1())
				.append("</shape1>\n");
		builder.append("<shape2>").append(obj.getLogoShape2())
				.append("</shape2>\n");
		builder.append("<shape3>").append(obj.getLogoShape3())
				.append("</shape3>\n");
		builder.append("<color1>").append(obj.getLogoColor1())
				.append("</color1>\n");
		builder.append("<color2>").append(obj.getLogoColor2())
				.append("</color2>\n");
		builder.append("<color3>").append(obj.getLogoColor3())
				.append("</color3>\n");
		builder.append("</logo>\n");

		builder.append("</result>\n");
		convertCloser(req, builder);

		return builder.toString();
	}
}
