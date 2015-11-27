package enterprises.orbital.evexmlapi.chr;

import java.util.Date;

public interface IContactNotification {
  public long getNotificationID();

  public long getSenderID();

  public String getSenderName();

  public Date getSentDate();

  public String getMessageData();
}
