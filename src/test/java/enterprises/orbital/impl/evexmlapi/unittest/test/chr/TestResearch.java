package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.IResearchAgent;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestResearch extends ApiTestSetup {

	@Test
	public void testGetResearch() throws IOException, ParseException,
			SAXException {
		// Retrieve response
		ICharacterAPI request = requestor.getCharacterAPIService(0,
				"na", 0L);
		Collection<IResearchAgent> response = request.requestResearchAgents();

		// Compute XML for comparison
		String testData = CharResearchConverter.convert(request, response);

		// Perform test
		ApiTestConnector.testComparison(ApiTestConnector.CHAR_RESEARCH_CTL,
				ApiTestConnector.CHAR_RESEARCH_TST,
				ApiTestConnector.CHAR_RESEARCH_OUT, testData);
	}

}
