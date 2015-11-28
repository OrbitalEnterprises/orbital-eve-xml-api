package enterprises.orbital.impl.evexmlapi.shared;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.shared.IMarketOrder;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiAuth;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public abstract class AbstractMarketOrdersParser extends AbstractApiParser<MarketOrdersResponse, Collection<IMarketOrder>> {
  protected Long orderID;

  protected AbstractMarketOrdersParser(ApiConnector connector, ApiEndpoint endpoint, Long orderID) {
    super(connector, MarketOrdersResponse.class, endpoint);
    this.orderID = orderID;
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiMarketOrder.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addMarketOrder");
    return digester;
  }

  public MarketOrdersResponse getResponseWithOrderID(ApiAuth auth) throws IOException {
    if (orderID != null) {
      Map<String, String> extraParams = new HashMap<String, String>();
      extraParams.put("orderid", Long.toString(orderID));
      return getResponse(auth, extraParams);
    } else
      return getResponse(auth);
  }

  @Override
  public Collection<IMarketOrder> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    MarketOrdersResponse response = getResponseWithOrderID(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IMarketOrder> result = new ArrayList<IMarketOrder>();
    result.addAll(response.getMarketOrders());
    return result;
  }

}