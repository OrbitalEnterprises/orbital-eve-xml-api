package enterprises.orbital.evexmlapi.chr;

import java.util.Date;

public interface INotification {
  public long getNotificationID();

  public int getTypeID();

  public long getSenderID();

  public Date getSentDate();

  public boolean isRead();
}
