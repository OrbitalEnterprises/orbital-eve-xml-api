package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.evexmlapi.chr.INotificationText;

public class NotificationText implements INotificationText {
  private long    notificationID;
  private String  notificationText;
  private boolean missing = false;

  @Override
  public long getNotificationID() {
    return notificationID;
  }

  public void setNotificationID(long notificationID) {
    this.notificationID = notificationID;
  }

  @Override
  public String getText() {
    return notificationText;
  }

  public void setNotificationText(String notificationText) {
    this.notificationText = notificationText;
  }

  @Override
  public boolean isMissing() {
    return missing;
  }

  public void setMissing(boolean missing) {
    this.missing = missing;
  }
}
