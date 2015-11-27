package enterprises.orbital.impl.evexmlapi.unittest.test.crp;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.crp.ICorporationAPI;
import enterprises.orbital.evexmlapi.shared.IContactSet;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestContactList extends ApiTestSetup {

  @Test
  public void testGetContactList() throws IOException, ParseException, SAXException {
    // Retrieve response
    ICorporationAPI request = requestor.getCorporationAPIService(0, "na", 0L);
    IContactSet response = request.requestContacts();

    // Compute XML for comparison
    String testData = CorpContactListConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiTestConnector.CORP_CONTACT_LIST_CTL, ApiTestConnector.CORP_CONTACT_LIST_TST, ApiTestConnector.CORP_CONTACT_LIST_OUT, testData);
  }

}
