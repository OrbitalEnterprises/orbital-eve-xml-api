package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.shared.IAsset;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestAssetList extends ApiTestSetup {

  @Test
  public void testGetAssetList() throws IOException, ParseException, SAXException {
    // Retrieve response
    ICharacterAPI request = requestor.getCharacterAPIService(0, "na", 0L);
    Collection<IAsset> response = request.requestAssets();

    // Compute XML for comparison
    String testData = CharAssetListConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiTestConnector.CHAR_ASSET_LIST_CTL, ApiTestConnector.CHAR_ASSET_LIST_TST, ApiTestConnector.CHAR_ASSET_LIST_OUT, testData);
  }

}
