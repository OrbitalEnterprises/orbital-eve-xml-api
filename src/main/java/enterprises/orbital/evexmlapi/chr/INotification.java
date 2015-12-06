package enterprises.orbital.evexmlapi.chr;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = INotification.class)
public interface INotification {
  public long getNotificationID();

  public int getTypeID();

  public long getSenderID();

  public Date getSentDate();

  public boolean isRead();
}
