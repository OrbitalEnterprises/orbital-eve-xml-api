package enterprises.orbital.evexmlapi.chr;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IMailBody.class)
public interface IMailBody {
  public String getBody();

  public long getMessageID();
}
