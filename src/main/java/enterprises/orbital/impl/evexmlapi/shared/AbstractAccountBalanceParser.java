package enterprises.orbital.impl.evexmlapi.shared;

import org.apache.commons.digester.Digester;

import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public abstract class AbstractAccountBalanceParser<F> extends AbstractApiParser<AccountBalanceResponse, F> {
  protected AbstractAccountBalanceParser(ApiConnector connector, ApiEndpoint endpoint) {
    super(connector, AccountBalanceResponse.class, endpoint);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiAccountBalance.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addAccountBalance");
    return digester;
  }
}