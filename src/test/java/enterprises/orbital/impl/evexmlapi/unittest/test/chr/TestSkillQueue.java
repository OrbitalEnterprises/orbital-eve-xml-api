package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.ISkillInQueue;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestSkillQueue extends ApiTestSetup {

	@Test
	public void testGetSkillQueue() throws IOException, ParseException,
			SAXException {
		// Retrieve response
		ICharacterAPI request = requestor.getCharacterAPIService(0,
				"na", 0L);
		Collection<ISkillInQueue> response = request.requestSkillQueue();

		// Compute XML for comparison
		String testData = CharSkillQueueConverter.convert(request, response);

		// Perform test
		ApiTestConnector.testComparison(ApiTestConnector.CHAR_SKILL_QUEUE_CTL,
				ApiTestConnector.CHAR_SKILL_QUEUE_TST,
				ApiTestConnector.CHAR_SKILL_QUEUE_OUT, testData);
	}

}
