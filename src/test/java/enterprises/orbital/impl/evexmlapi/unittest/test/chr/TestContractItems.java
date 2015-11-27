package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.shared.IContractItem;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestContractItems extends ApiTestSetup {

  @Test
  public void testGetContractItems() throws IOException, ParseException, SAXException {
    // Retrieve response
    ICharacterAPI request = requestor.getCharacterAPIService(0, "na", 0L);
    Collection<IContractItem> response = request.requestContractItems(0);

    // Compute XML for comparison
    String testData = CharContractItemsConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiTestConnector.CHAR_CONTRACT_ITEMS_CTL, ApiTestConnector.CHAR_CONTRACT_ITEMS_TST, ApiTestConnector.CHAR_CONTRACT_ITEMS_OUT, testData);
  }

}
