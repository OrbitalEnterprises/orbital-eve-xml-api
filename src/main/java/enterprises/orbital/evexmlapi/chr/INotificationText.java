package enterprises.orbital.evexmlapi.chr;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = INotificationText.class)
public interface INotificationText {
  public String getText();

  public long getNotificationID();

  public boolean isMissing();
}
