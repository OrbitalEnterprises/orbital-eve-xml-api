package enterprises.orbital.impl.evexmlapi.chr;

import java.io.IOException;

import enterprises.orbital.evexmlapi.shared.IAccountBalance;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractAccountBalanceParser;
import enterprises.orbital.impl.evexmlapi.shared.AccountBalanceResponse;

public class AccountBalanceParser extends AbstractAccountBalanceParser<IAccountBalance> {
  public AccountBalanceParser() {
    super(ApiEndpoint.CHR_ACCOUNT_BALANCE_V2);
  }

  @Override
  public IAccountBalance retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    AccountBalanceResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    assert !response.getAccountBalances().isEmpty();
    return response.getAccountBalances().iterator().next();
  }

}