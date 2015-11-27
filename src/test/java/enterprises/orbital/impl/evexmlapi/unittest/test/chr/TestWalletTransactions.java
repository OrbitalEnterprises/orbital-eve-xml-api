package enterprises.orbital.impl.evexmlapi.unittest.test.chr;

import java.io.IOException;
import java.text.ParseException;
import java.util.Collection;

import org.junit.Test;
import org.xml.sax.SAXException;

import enterprises.orbital.evexmlapi.chr.ICharacterAPI;
import enterprises.orbital.evexmlapi.shared.IWalletTransaction;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestConnector;
import enterprises.orbital.impl.evexmlapi.unittest.test.ApiTestSetup;

public class TestWalletTransactions extends ApiTestSetup {

	@Test
	public void testGetWalletTransactions() throws IOException, ParseException,
			SAXException {
		// Retrieve response
		ICharacterAPI request = requestor.getCharacterAPIService(0,
				"na", 0L);
		Collection<IWalletTransaction> response = request
				.requestWalletTransactions();

		// Compute XML for comparison
		String testData = CharWalletTransactionsConverter.convert(request,
				response);

		// Perform test
		ApiTestConnector.testComparison(
				ApiTestConnector.CHAR_WALLET_TRANSACTIONS_CTL,
				ApiTestConnector.CHAR_WALLET_TRANSACTIONS_TST,
				ApiTestConnector.CHAR_WALLET_TRANSACTIONS_OUT, testData);
	}

}
