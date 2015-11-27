package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.crp.IContainerLog;
import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestContainerLog extends ApiTestSetup {

	@Test
	public void testGetContainerLog() throws IOException, ParseException,
			SAXException {
		// Retrieve response
		ICorporationAPI request = requestor.getCorporationAPIService(0,
				"na", 0L);
		Collection<IContainerLog> response = request.requestContainerLogs();

		// Compute XML for comparison
		String testData = CorpContainerLogConverter.convert(request, response);

		// Perform test
		ApiTestConnector.testComparison(ApiTestConnector.CORP_CONTAINER_LOG_CTL,
				ApiTestConnector.CORP_CONTAINER_LOG_TST,
				ApiTestConnector.CORP_CONTAINER_LOG_OUT, testData);
	}

}
