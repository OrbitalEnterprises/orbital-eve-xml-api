package enterprises.orbital.impl.evexmlapi.shared;

import java.util.ArrayList;
import java.util.List;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class WalletTransactionsResponse extends ApiResponse {
  private static final long                serialVersionUID   = -3445961567102363426L;
  private final List<ApiWalletTransaction> walletTransactions = new ArrayList<ApiWalletTransaction>();

  public void addWalletTransaction(ApiWalletTransaction walletTransaction) {
    walletTransactions.add(walletTransaction);
  }

  public List<ApiWalletTransaction> getWalletTransactions() {
    return walletTransactions;
  }
}