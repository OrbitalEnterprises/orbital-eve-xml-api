package enterprises.orbital.impl.evexmlapi.unittest.test.eve;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.eve.IEveAPI;
import enterprises.orbital.evexmlapi.eve.ISkillGroup;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestSkillTree extends ApiTestSetup {

  @Test
  public void testGetSkillTree() throws IOException, ParseException, SAXException {
    // Retrieve response
    IEveAPI request = requestor.getEveAPIService();
    Collection<ISkillGroup> response = request.requestSkillTree();

    // Compute XML for comparison
    String testData = EveSkillTreeConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiEndpoint.EVE_SKILL_TREE_V2, testConnector.getLastRequestParams(), testData);
  }

}
