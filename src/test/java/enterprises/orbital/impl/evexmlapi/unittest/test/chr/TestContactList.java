package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.io.IOException;
import java.text.ParseException;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.shared.IContactSet;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestContactList extends ApiTestSetup {

  @Test
  public void testGetContactList() throws IOException, ParseException, SAXException {
    // Retrieve response
    ICharacterAPI request = requestor.getCharacterAPIService(0, "na", 0L);
    IContactSet response = request.requestContacts();

    // Compute XML for comparison
    String testData = CharContactListConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiTestConnector.CHAR_CONTACT_LIST_CTL, ApiTestConnector.CHAR_CONTACT_LIST_TST, ApiTestConnector.CHAR_CONTACT_LIST_OUT, testData);
  }

}
