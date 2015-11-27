package enterprises.orbital.impl.evexmlapi.chr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.chr.IContactNotification;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class ContactNotificationsParser extends AbstractApiParser<ContactNotificationsResponse, Collection<IContactNotification>> {
  public ContactNotificationsParser() {
    super(ContactNotificationsResponse.class, ApiEndpoint.CHR_CONTACT_NOTIFICATIONS_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiContactNotification.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "add");
    return digester;
  }

  @Override
  public Collection<IContactNotification> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    ContactNotificationsResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IContactNotification> result = new ArrayList<IContactNotification>();
    result.addAll(response.getContactNotifications());
    return result;
  }

}