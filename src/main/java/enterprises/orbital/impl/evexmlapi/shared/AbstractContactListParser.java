package enterprises.orbital.impl.evexmlapi.shared;

import java.io.IOException;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.shared.IContactSet;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public abstract class AbstractContactListParser extends AbstractApiParser<ContactListResponse, IContactSet> {
  protected AbstractContactListParser(ApiConnector connector, ApiEndpoint endpoint) {
    super(connector, ContactListResponse.class, endpoint);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset", ContactList.class);
    digester.addSetProperties("eveapi/result/rowset");
    digester.addObjectCreate("eveapi/result/rowset/row", ApiContact.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "add");
    digester.addSetNext("eveapi/result/rowset", "addContactList");
    return digester;
  }

  @Override
  public IContactSet retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    ContactListResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    return response;
  }

}