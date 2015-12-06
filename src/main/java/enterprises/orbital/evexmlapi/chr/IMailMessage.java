package enterprises.orbital.evexmlapi.chr;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IMailMessage.class)
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
