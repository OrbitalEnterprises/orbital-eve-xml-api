package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.crp.IMemberTracking;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestMemberTracking extends ApiTestSetup {

	@Test
	public void testGetMemberTracking() throws IOException, ParseException,
			SAXException {
		// Retrieve response
		ICorporationAPI request = requestor.getCorporationAPIService(0,
				"na", 0L);
		Collection<IMemberTracking> response = request.requestMemberTracking();

		// Compute XML for comparison
		String testData = CorpMemberTrackingConverter
				.convert(request, response);

		// Perform test
		ApiTestConnector.testComparison(ApiTestConnector.CORP_MEMBER_TRACKING_CTL,
				ApiTestConnector.CORP_MEMBER_TRACKING_TST,
				ApiTestConnector.CORP_MEMBER_TRACKING_OUT, testData);
	}

}
