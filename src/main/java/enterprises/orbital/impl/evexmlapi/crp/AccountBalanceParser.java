package enterprises.orbital.impl.evexmlapi.crp;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

import enterprises.orbital.evexmlapi.shared.IAccountBalance;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractAccountBalanceParser;
import enterprises.orbital.impl.evexmlapi.shared.AccountBalanceResponse;

public class AccountBalanceParser extends AbstractAccountBalanceParser<Collection<IAccountBalance>> {
  public AccountBalanceParser() {
    super(ApiEndpoint.CRP_ACCOUNT_BALANCE_V2);
  }

  @Override
  public Collection<IAccountBalance> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    AccountBalanceResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    assert !response.getAccountBalances().isEmpty();
    Collection<IAccountBalance> result = new HashSet<IAccountBalance>();
    result.addAll(response.getAccountBalances());
    return result;
  }
}