package enterprises.orbital.evexmlapi.chr;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(
    as = IUpcomingCalendarEvent.class)
public interface IUpcomingCalendarEvent {
  public int getDuration();

  public Date getEventDate();

  public long getEventID();

  public String getEventText();

  public String getEventTitle();

  public long getOwnerID();

  public String getOwnerName();

  public String getResponse();

  public boolean isImportant();
}
