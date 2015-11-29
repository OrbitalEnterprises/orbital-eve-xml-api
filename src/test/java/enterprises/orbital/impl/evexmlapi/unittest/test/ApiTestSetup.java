package enterprises.orbital.impl.evexmlapi.unittest.test;

import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

import enterprises.orbital.evexmlapi.EveXmlApiAdapter;
import enterprises.orbital.evexmlapi.IEveXmlApi;

public abstract class ApiTestSetup {

  protected static ApiTestConnector testConnector;
  protected static IEveXmlApi       requestor;
  protected static SimpleDateFormat dateFormatter;

  static {
    try {
      testConnector = new ApiTestConnector(new URI("https://api.eveonline.com"), null, -1, -1);
      requestor = new EveXmlApiAdapter().setConnector(testConnector);
    } catch (URISyntaxException e) {
      // Rethrow to cause tests to fail.
      throw new RuntimeException(e);
    }
    dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    dateFormatter.setTimeZone(TimeZone.getTimeZone("GMT"));
  }

}
