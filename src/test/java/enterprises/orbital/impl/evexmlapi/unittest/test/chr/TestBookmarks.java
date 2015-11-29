package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.shared.IBookmarkFolder;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestBookmarks extends ApiTestSetup {

  @Test
  public void testGetBookmarks() throws IOException, ParseException, SAXException {
    // Retrieve response
    ICharacterAPI request = requestor.getCharacterAPIService(0, "na", 0L);
    Collection<IBookmarkFolder> response = request.requestBookmarks();

    // Compute XML for comparison
    String testData = CharBookmarksConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiEndpoint.CHR_BOOKMARKS_V2, testConnector.getLastRequestParams(), testData);
  }

}
