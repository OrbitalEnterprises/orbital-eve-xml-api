package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.shared.IWalletJournalEntry;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestWalletJournal extends ApiTestSetup {

	@Test
	public void testGetWalletJournal() throws IOException, ParseException,
			SAXException {
		// Retrieve response
		ICharacterAPI request = requestor.getCharacterAPIService(0,
				"na", 0L);
		Collection<IWalletJournalEntry> response = request
				.requestWalletJournalEntries();

		// Compute XML for comparison
		String testData = CharWalletJournalConverter.convert(request, response);

		// Perform test
		ApiTestConnector.testComparison(ApiTestConnector.CHAR_WALLET_JOURNAL_CTL,
				ApiTestConnector.CHAR_WALLET_JOURNAL_TST,
				ApiTestConnector.CHAR_WALLET_JOURNAL_OUT, testData);
	}

}
