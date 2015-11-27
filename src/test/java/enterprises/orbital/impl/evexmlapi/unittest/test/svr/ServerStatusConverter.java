package enterprises.orbital.impl.evexmlapi.unittest.test.svr;

import enterprises.orbital.evexmlapi.svr.IServerAPI;
import enterprises.orbital.evexmlapi.svr.IServerStatus;
import enterprises.orbital.impl.evexmlapi.unittest.test.ResponseConverter;

public class ServerStatusConverter extends ResponseConverter {

	public static String convert(IServerAPI request,
			IServerStatus response) {
		StringBuilder builder = new StringBuilder();

		convertOpener(request, builder);
		builder.append("<result>\n");
		builder.append("<serverOpen>");
		builder.append(response.isServerOpen() ? "True" : "False");
		builder.append("</serverOpen>\n");
		builder.append("<onlinePlayers>").append(response.getOnlinePlayers());
		builder.append("</onlinePlayers>\n");
		builder.append("</result>\n");

		convertCloser(request, builder);
		return builder.toString();
	}
}
