package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.chr.IChatChannel;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestChatChannels extends ApiTestSetup {

  @Test
  public void testGetChatChannels() throws IOException, ParseException, SAXException {
    // Retrieve response
    ICharacterAPI request = requestor.getCharacterAPIService(0, "na", 0L);
    Collection<IChatChannel> response = request.requestChatChannels();

    // Compute XML for comparison
    String testData = CharChatChannelsConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiTestConnector.CHAR_CHATCHANNELS_CTL, ApiTestConnector.CHAR_CHATCHANNELS_TST, ApiTestConnector.CHAR_CHATCHANNELS_OUT,
                                    testData);
  }

}
