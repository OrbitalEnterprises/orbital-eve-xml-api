package enterprises.orbital.impl.evexmlapi.crp;

import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractMarketOrdersParser;

public class MarketOrdersParser extends AbstractMarketOrdersParser {
  public MarketOrdersParser(Long orderID) {
    super(ApiEndpoint.CRP_MARKET_ORDERS_V2, orderID);
  }
}