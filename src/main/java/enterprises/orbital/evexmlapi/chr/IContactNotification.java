package enterprises.orbital.evexmlapi.chr;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IContactNotification.class)
public interface IContactNotification {
  public long getNotificationID();

  public long getSenderID();

  public String getSenderName();

  public Date getSentDate();

  public String getMessageData();
}
