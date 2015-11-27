package enterprises.orbital.evexmlapi.chr;

import java.util.Date;

public interface IMailMessage {
  public long getMessageID();

  public long getSenderID();

  public String getSenderName();

  public Date getSentDate();

  public String getTitle();

  public long[] getToCharacterIDs();

  public long getToCorpOrAllianceID();

  public long[] getToListID();

  public boolean isRead();

  public int getSenderTypeID();
}
