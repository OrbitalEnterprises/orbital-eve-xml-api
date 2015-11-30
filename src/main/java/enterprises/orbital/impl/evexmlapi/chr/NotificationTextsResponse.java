package enterprises.orbital.impl.evexmlapi.chr;

import java.util.ArrayList;
import java.util.Collection;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class NotificationTextsResponse extends ApiResponse {
  private final Collection<NotificationText> texts   = new ArrayList<NotificationText>();
  private final Collection<Long>             missing = new ArrayList<Long>();

  public void addNotification(NotificationText item) {
    texts.add(item);
  }

  public Collection<NotificationText> getNotificationTexts() {
    return texts;
  }

  public void setMissingID(long id) {
    missing.add(id);
  }

  public Collection<Long> getMissingTexts() {
    return missing;
  }
}
