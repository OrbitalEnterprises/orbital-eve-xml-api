package enterprises.orbital.impl.evexmlapi.chr;

import java.util.HashSet;
import java.util.Set;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class NotificationsResponse extends ApiResponse {
  private final Set<ApiNotification> notifications = new HashSet<ApiNotification>();

  public void addNotification(ApiNotification member) {
    notifications.add(member);
  }

  public Set<ApiNotification> getNotifications() {
    return notifications;
  }
}