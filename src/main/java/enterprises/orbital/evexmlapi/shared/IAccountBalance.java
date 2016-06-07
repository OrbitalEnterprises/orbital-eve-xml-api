package enterprises.orbital.evexmlapi.shared;

import java.math.BigDecimal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IAccountBalance.class)
public interface IAccountBalance {
  public int getAccountID();

  public int getAccountKey();

  public BigDecimal getBalance();
}
