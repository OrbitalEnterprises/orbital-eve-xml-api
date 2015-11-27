package enterprises.orbital.evexmlapi.shared;

import java.math.BigDecimal;

public interface IAccountBalance {
  public int getAccountID();

  public int getAccountKey();

  public BigDecimal getBalance();
}
