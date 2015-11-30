package enterprises.orbital.impl.evexmlapi.unittest.test.eve;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.eve.IEveAPI;
import enterprises.orbital.evexmlapi.eve.IRefType;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestRefTypesList extends ApiTestSetup {

  @Test
  public void testGetRefTypesList() throws IOException, ParseException, SAXException {
    // Retrieve response
    IEveAPI request = requestor.getEveAPIService();
    Collection<IRefType> response = request.requestRefTypes();

    // Compute XML for comparison
    String testData = EveRefTypesListConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiEndpoint.EVE_REF_TYPES_V1, testConnector.getLastRequestParams(), testData);
  }

}
