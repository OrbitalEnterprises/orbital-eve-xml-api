package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.shared.IMarketOrder;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestMarketOrders extends ApiTestSetup {

  @Test
  public void testGetMarketOrders() throws IOException, ParseException, SAXException {
    // Retrieve response
    ICharacterAPI request = requestor.getCharacterAPIService(0, "na", 0L);
    Collection<IMarketOrder> response = request.requestMarketOrders();

    // Compute XML for comparison
    String testData = CharMarketOrdersConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiTestConnector.CHAR_MARKET_ORDERS_CTL, ApiTestConnector.CHAR_MARKET_ORDERS_TST, ApiTestConnector.CHAR_MARKET_ORDERS_OUT, testData);
  }

  @Test
  public void testGetMarketOrderByID() throws IOException, ParseException, SAXException {
    // Retrieve response
    ICharacterAPI request = requestor.getCharacterAPIService(0, "na", 0L);
    // NOTE: tied to the sample file. If you update the sample file, you'll probably need to update the orderID below.
    IMarketOrder response = request.requestMarketOrder(2735818192L);
    Collection<IMarketOrder> responseCollection = new ArrayList<IMarketOrder>();
    if (response != null) responseCollection.add(response);

    // Compute XML for comparison
    String testData = CharMarketOrdersConverter.convert(request, responseCollection);

    // Perform test
    ApiTestConnector.testComparison(ApiTestConnector.CHAR_MARKET_ORDERS_CTL, ApiTestConnector.CHAR_MARKET_ORDERS_TST, ApiTestConnector.CHAR_MARKET_ORDERS_OUT, testData);
  }

}
