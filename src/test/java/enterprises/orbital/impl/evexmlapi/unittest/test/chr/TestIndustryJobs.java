package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.shared.IIndustryJob;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestIndustryJobs extends ApiTestSetup {

	@Test
	public void testGetIndustryJobs() throws IOException, ParseException,
			SAXException {
		// Retrieve response
		ICharacterAPI request = requestor.getCharacterAPIService(0,
				"na", 0L);
		Collection<IIndustryJob> response = request.requestIndustryJobs();

		// Compute XML for comparison
		String testData = CharIndustryJobsConverter.convert(request, response);

		// Perform test
		ApiTestConnector.testComparison(ApiTestConnector.CHAR_INDUSTRY_JOBS_CTL,
				ApiTestConnector.CHAR_INDUSTRY_JOBS_TST,
				ApiTestConnector.CHAR_INDUSTRY_JOBS_OUT, testData);
	}

}
