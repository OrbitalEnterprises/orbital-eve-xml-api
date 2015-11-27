package enterprises.orbital.impl.evexmlapi.chr;

import java.util.Date;

import enterprises.orbital.evexmlapi.chr.IContactNotification;

public class ApiContactNotification implements IContactNotification {
  private long   notificationID;
  private long   senderID;
  private String senderName;
  private Date   sentDate;
  private String messageData;

  @Override
  public long getNotificationID() {
    return notificationID;
  }

  public void setNotificationID(long notificationID) {
    this.notificationID = notificationID;
  }

  @Override
  public long getSenderID() {
    return senderID;
  }

  public void setSenderID(long senderID) {
    this.senderID = senderID;
  }

  @Override
  public String getSenderName() {
    return senderName;
  }

  public void setSenderName(String sentName) {
    this.senderName = sentName;
  }

  @Override
  public Date getSentDate() {
    return sentDate;
  }

  public void setSentDate(Date sentDate) {
    this.sentDate = sentDate;
  }

  @Override
  public String getMessageData() {
    return messageData;
  }

  public void setMessageData(String messageData) {
    this.messageData = messageData;
  }
}