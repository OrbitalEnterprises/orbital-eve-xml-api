package enterprises.orbital.impl.evexmlapi.unittest.test;

import java.text.SimpleDateFormat;
import java.util.TimeZone;

import enterprises.orbital.evexmlapi.EveXmlApiAdapter;
import enterprises.orbital.evexmlapi.IEveXmlApi;
import enterprises.orbital.impl.evexmlapi.EveApi;

public abstract class ApiTestSetup {

	protected static IEveXmlApi requestor;
	protected static SimpleDateFormat dateFormatter;

	static {
		EveApi.setConnector(new ApiTestConnector());
		requestor = new EveXmlApiAdapter();
		dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		dateFormatter.setTimeZone(TimeZone.getTimeZone("GMT"));
	}

}
