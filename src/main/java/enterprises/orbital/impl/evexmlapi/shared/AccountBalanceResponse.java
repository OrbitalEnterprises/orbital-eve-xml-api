package enterprises.orbital.impl.evexmlapi.shared;

import java.util.Collection;
import java.util.HashSet;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class AccountBalanceResponse extends ApiResponse {
  private final Collection<ApiAccountBalance> accountBalances = new HashSet<ApiAccountBalance>();

  public void addAccountBalance(ApiAccountBalance accountBalance) {
    accountBalances.add(accountBalance);
  }

  public Collection<ApiAccountBalance> getAccountBalances() {
    return accountBalances;
  }
}