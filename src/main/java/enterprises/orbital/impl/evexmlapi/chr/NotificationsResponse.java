package enterprises.orbital.impl.evexmlapi.chr;

import java.util.HashSet;
import java.util.Set;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class NotificationsResponse extends ApiResponse {
  private static final long          serialVersionUID = 2965395224692281655L;
  private final Set<ApiNotification> notifications    = new HashSet<ApiNotification>();

  public void addNotification(ApiNotification member) {
    notifications.add(member);
  }

  public Set<ApiNotification> getNotifications() {
    return notifications;
  }
}