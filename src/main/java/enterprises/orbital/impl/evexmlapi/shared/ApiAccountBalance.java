package enterprises.orbital.impl.evexmlapi.shared;

import java.math.BigDecimal;
import java.math.RoundingMode;

import enterprises.orbital.evexmlapi.shared.IAccountBalance;

public class ApiAccountBalance implements IAccountBalance {
  private int        accountID;
  private int        accountKey;
  private BigDecimal balance;

  @Override
  public int getAccountID() {
    return accountID;
  }

  public void setAccountID(int accountID) {
    this.accountID = accountID;
  }

  @Override
  public int getAccountKey() {
    return accountKey;
  }

  public void setAccountKey(int accountKey) {
    this.accountKey = accountKey;
  }

  @Override
  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(BigDecimal balance) {
    this.balance = balance.setScale(2, RoundingMode.HALF_UP);
  }
}