package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractMarketOrdersParser;

public class MarketOrdersParser extends AbstractMarketOrdersParser {
  public MarketOrdersParser(Long orderID) {
    super(ApiEndpoint.CHR_MARKET_ORDERS_V2, orderID);
  }
}