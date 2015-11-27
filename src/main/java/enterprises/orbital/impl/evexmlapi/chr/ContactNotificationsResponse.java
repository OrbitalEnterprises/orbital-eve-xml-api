package enterprises.orbital.impl.evexmlapi.chr;

import java.util.ArrayList;
import java.util.List;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class ContactNotificationsResponse extends ApiResponse {
  private static final long            serialVersionUID     = 5799608242646406611L;
  private List<ApiContactNotification> contactNotifications = new ArrayList<ApiContactNotification>();

  public void add(ApiContactNotification notification) {
    contactNotifications.add(notification);
  }

  public List<ApiContactNotification> getContactNotifications() {
    return contactNotifications;
  }
}