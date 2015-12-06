package enterprises.orbital.evexmlapi.chr;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = ICalendarEventAttendee.class)
public interface ICalendarEventAttendee {
  public int getEventID();

  public long getCharacterID();

  public String getCharacterName();

  public String getResponse();
}
