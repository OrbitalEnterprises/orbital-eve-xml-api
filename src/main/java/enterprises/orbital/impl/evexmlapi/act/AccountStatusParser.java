package enterprises.orbital.impl.evexmlapi.act;

import java.io.IOException;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.act.IAccountStatus;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class AccountStatusParser extends AbstractApiParser<AccountStatusResponse, IAccountStatus> {
  public AccountStatusParser(ApiConnector connector) {
    super(connector, AccountStatusResponse.class, ApiEndpoint.ACT_ACCOUNT_STATUS_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addBeanPropertySetter("eveapi/result/paidUntil");
    digester.addBeanPropertySetter("eveapi/result/createDate");
    digester.addBeanPropertySetter("eveapi/result/logonCount");
    digester.addBeanPropertySetter("eveapi/result/logonMinutes");

    digester.addObjectCreate("eveapi/result/rowset/row", ApiMultiCharacterTraining.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addMultiCharacterTraining");

    return digester;
  }

  @Override
  public IAccountStatus retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    AccountStatusResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    return response;
  }
}