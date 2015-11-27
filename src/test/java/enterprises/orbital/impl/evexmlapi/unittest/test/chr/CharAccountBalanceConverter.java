package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.shared.IAccountBalance;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CharAccountBalanceConverter extends ResponseConverter {

	public static String convert(ICharacterAPI req, IAccountBalance obj) {
		StringBuilder builder = new StringBuilder();

		convertOpener(req, builder);
		builder.append("<result>\n");
		builder.append("<rowset name=\"accounts\" key=\"accountID\" columns=\"accountID,accountKey,balance\">\n");
		builder.append("<row accountID=\"").append(obj.getAccountID());
		builder.append("\" accountKey=\"").append(obj.getAccountKey());
		builder.append("\" balance=\"").append(
				String.format("%.2f", obj.getBalance()));
		builder.append("\" />\n");
		builder.append("</rowset>\n");
		builder.append("</result>\n");
		convertCloser(req, builder);

		return builder.toString();
	}
}
