package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.shared.IIndustryJob;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestIndustryJobsHistory extends ApiTestSetup {

  @Test
  public void testGetIndustryJobsHistory() throws IOException, ParseException, SAXException {
    // Retrieve response
    ICharacterAPI request = requestor.getCharacterAPIService(0, "na", 0L);
    Collection<IIndustryJob> response = request.requestIndustryJobsHistory();

    // Compute XML for comparison
    String testData = CharIndustryJobsConverter.convert(request, response);

    // Perform test
    ApiTestConnector.testComparison(ApiEndpoint.CHR_INDUSTRY_JOBS_HISTORY_V2, testConnector.getLastRequestParams(), testData);
  }

}
