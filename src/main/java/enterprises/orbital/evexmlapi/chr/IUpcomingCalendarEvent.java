package enterprises.orbital.evexmlapi.chr;

import java.util.Date;

public interface IUpcomingCalendarEvent {
  public int getDuration();

  public Date getEventDate();

  public int getEventID();

  public String getEventText();

  public String getEventTitle();

  public long getOwnerID();

  public String getOwnerName();

  public String getResponse();

  public boolean isImportant();
}
