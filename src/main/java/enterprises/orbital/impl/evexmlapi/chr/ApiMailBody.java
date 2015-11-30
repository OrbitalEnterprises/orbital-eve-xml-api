package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.evexmlapi.chr.IMailBody;

public class ApiMailBody implements IMailBody {
  private long   messageID;
  private String body;

  public long getMessageID() {
    return messageID;
  }

  public void setMessageID(long messageID) {
    this.messageID = messageID;
  }

  public String getBody() {
    return body;
  }

  public void setBody(String title) {
    this.body = title;
  }
}