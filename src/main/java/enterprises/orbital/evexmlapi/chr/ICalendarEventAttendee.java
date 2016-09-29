package enterprises.orbital.evexmlapi.chr;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(
    as = ICalendarEventAttendee.class)
public interface ICalendarEventAttendee {
  public long getEventID();

  public long getCharacterID();

  public String getCharacterName();

  public String getResponse();
}
