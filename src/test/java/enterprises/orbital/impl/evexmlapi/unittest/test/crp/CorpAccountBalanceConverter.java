package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.util.Collection;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.shared.IAccountBalance;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class CorpAccountBalanceConverter extends ResponseConverter {

	public static String convert(ICorporationAPI req,
			Collection<IAccountBalance> obj) {
		StringBuilder builder = new StringBuilder();

		convertOpener(req, builder);
		builder.append("<result>\n");
		builder.append("<rowset name=\"accounts\" key=\"accountID\" columns=\"accountID,accountKey,balance\">\n");

		for (IAccountBalance next : obj) {
			builder.append("<row accountID=\"").append(next.getAccountID());
			builder.append("\" accountKey=\"").append(next.getAccountKey());
			builder.append("\" balance=\"").append(
					String.format("%.2f", next.getBalance()));
			builder.append("\" />\n");
		}

		builder.append("</rowset>\n");
		builder.append("</result>\n");
		convertCloser(req, builder);

		return builder.toString();
	}
}
