package enterprises.orbital.impl.evexmlapi.chr;

import java.util.Date;

import enterprises.orbital.evexmlapi.chr.IMailMessage;

public class ApiMailMessage implements IMailMessage {
  private long    messageID;
  private long    senderID;
  private String  senderName;
  private Date    sentDate;
  private String  title;
  private long    toCorpOrAllianceID;
  private long[]  toCharacterIDs;
  private long[]  toListID;
  private boolean read;
  private int     senderTypeID;

  @Override
  public long getMessageID() {
    return messageID;
  }

  public void setMessageID(long messageID) {
    this.messageID = messageID;
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

  public void setSenderName(String senderName) {
    this.senderName = senderName;
  }

  @Override
  public Date getSentDate() {
    return sentDate;
  }

  public void setSentDate(Date sentDate) {
    this.sentDate = sentDate;
  }

  @Override
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public long getToCorpOrAllianceID() {
    return toCorpOrAllianceID;
  }

  public void setToCorpOrAllianceID(long toCorpOrAllianceID) {
    this.toCorpOrAllianceID = toCorpOrAllianceID;
  }

  @Override
  public long[] getToCharacterIDs() {
    return toCharacterIDs;
  }

  public void setToCharacterIDs(long[] toCharacterIDs) {
    this.toCharacterIDs = toCharacterIDs;
  }

  @Override
  public long[] getToListID() {
    return toListID;
  }

  public void setToListID(long[] toListID) {
    this.toListID = toListID;
  }

  @Override
  public boolean isRead() {
    return read;
  }

  public void setRead(boolean read) {
    this.read = read;
  }

  @Override
  public int getSenderTypeID() {
    return senderTypeID;
  }

  public void setSenderTypeID(int senderTypeID) {
    this.senderTypeID = senderTypeID;
  }

}
