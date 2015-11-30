package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractMarketOrdersParser;

public class MarketOrdersParser extends AbstractMarketOrdersParser {
  public MarketOrdersParser(ApiConnector connector, Long orderID) {
    super(connector, ApiEndpoint.CHR_MARKET_ORDERS_V2, orderID);
  }
}