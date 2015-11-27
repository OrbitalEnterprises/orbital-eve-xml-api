package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.crp.ICustomsOffice;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestCustomsOffices extends ApiTestSetup {

  @Test
  public void testGetCustomsOffices() throws IOException, ParseException, SAXException {
    // Retrieve response
    ICorporationAPI request = requestor.getCorporationAPIService(0, "na", 0L);
    Collection<ICustomsOffice> response = request.requestCustomsOffices();

    // Compute XML for comparison
    String testData = CorpCustomsOfficesConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiTestConnector.CORP_CUSTOMS_OFFICES_CTL, ApiTestConnector.CORP_CUSTOMS_OFFICES_TST, ApiTestConnector.CORP_CUSTOMS_OFFICES_OUT,
                                 testData);
  }

}
