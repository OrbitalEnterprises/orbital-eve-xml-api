package enterprises.orbital.impl.evexmlapi.crp;

import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractMarketOrdersParser;

public class MarketOrdersParser extends AbstractMarketOrdersParser {
  public MarketOrdersParser(ApiConnector connector, Long orderID) {
    super(connector, ApiEndpoint.CRP_MARKET_ORDERS_V2, orderID);
  }
}