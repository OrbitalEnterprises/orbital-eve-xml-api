package enterprises.orbital.impl.evexmlapi.shared;

import java.util.ArrayList;
import java.util.Collection;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class MarketOrdersResponse extends ApiResponse {
  private final Collection<ApiMarketOrder> marketOrders = new ArrayList<ApiMarketOrder>();

  public void addMarketOrder(ApiMarketOrder order) {
    marketOrders.add(order);
  }

  public Collection<ApiMarketOrder> getMarketOrders() {
    return marketOrders;
  }
}
