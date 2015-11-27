package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.ISkillInTraining;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestSkillInTraining extends ApiTestSetup {

	@Test
	public void testGetSkillInTraining() throws IOException, ParseException,
			SAXException {
		// Retrieve response
		ICharacterAPI request = requestor.getCharacterAPIService(0,
				"na", 0L);
		ISkillInTraining response = request.requestSkillInTraining();

		// Compute XML for comparison
		String testData = CharSkillInTrainingConverter.convert(request,
				response);

		// Perform test
		ApiTestConnector.testComparison(ApiTestConnector.CHAR_SKILL_IN_TRAINING_CTL,
				ApiTestConnector.CHAR_SKILL_IN_TRAINING_TST,
				ApiTestConnector.CHAR_SKILL_IN_TRAINING_OUT, testData);
	}

}
