package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.shared.IBlueprint;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestBlueprintList extends ApiTestSetup {

  @Test
  public void testGetBlueprintList() throws IOException, ParseException, SAXException {
    // Retrieve response
    ICorporationAPI request = requestor.getCorporationAPIService(0, "na", 0L);
    Collection<IBlueprint> response = request.requestBlueprints();

    // Compute XML for comparison
    String testData = CorpBlueprintsConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiTestConnector.CORP_BLUEPRINTS_CTL, ApiTestConnector.CORP_BLUEPRINTS_TST, ApiTestConnector.CORP_BLUEPRINTS_OUT, testData);
  }

}
