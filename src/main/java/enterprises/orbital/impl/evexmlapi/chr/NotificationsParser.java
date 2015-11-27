package enterprises.orbital.impl.evexmlapi.chr;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.chr.INotification;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class NotificationsParser extends AbstractApiParser<NotificationsResponse, Collection<INotification>> {
  public NotificationsParser() {
    super(NotificationsResponse.class, ApiEndpoint.CHR_NOTIFICATIONS_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiNotification.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addNotification");
    return digester;
  }

  @Override
  public Collection<INotification> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    NotificationsResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<INotification> result = new HashSet<INotification>();
    result.addAll(response.getNotifications());
    return result;
  }
}