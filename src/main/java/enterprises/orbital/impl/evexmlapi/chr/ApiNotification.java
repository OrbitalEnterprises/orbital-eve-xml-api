package enterprises.orbital.impl.evexmlapi.chr;

import java.util.Date;

import enterprises.orbital.evexmlapi.chr.INotification;

public class ApiNotification implements INotification {
  private long    notificationID;
  private int     typeID;
  private long    senderID;
  private Date    sentDate;
  private boolean read;

  @Override
  public long getNotificationID() {
    return notificationID;
  }

  public void setNotificationID(long notificationID) {
    this.notificationID = notificationID;
  }

  @Override
  public int getTypeID() {
    return typeID;
  }

  public void setTypeID(int typeID) {
    this.typeID = typeID;
  }

  @Override
  public long getSenderID() {
    return senderID;
  }

  public void setSenderID(long senderID) {
    this.senderID = senderID;
  }

  @Override
  public Date getSentDate() {
    return sentDate;
  }

  public void setSentDate(Date sentDate) {
    this.sentDate = sentDate;
  }

  @Override
  public boolean isRead() {
    return read;
  }

  public void setRead(boolean read) {
    this.read = read;
  }
}