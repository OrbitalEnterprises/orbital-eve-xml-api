package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.crp.IFacility;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestFacilities extends ApiTestSetup {

  @Test
  public void testGetFacilities() throws IOException, ParseException, SAXException {
    // Retrieve response
    ICorporationAPI request = requestor.getCorporationAPIService(0, "na", 0L);
    Collection<IFacility> response = request.requestFacilities();

    // Compute XML for comparison
    String testData = CorpFacilitiesConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiTestConnector.CORP_FACILITIES_CTL, ApiTestConnector.CORP_FACILITIES_TST, ApiTestConnector.CORP_FACILITIES_OUT, testData);
  }

}
