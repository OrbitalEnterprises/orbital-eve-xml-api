package enterprises.orbital.impl.evexmlapi.chr;

import java.util.ArrayList;
import java.util.Collection;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class CalendarEventAttendeeResponse extends ApiResponse {
  private final Collection<CalendarEventAttendee> attendees = new ArrayList<CalendarEventAttendee>();

  public void addAttendee(CalendarEventAttendee item) {
    attendees.add(item);
  }

  public Collection<CalendarEventAttendee> getAttendees() {
    return attendees;
  }
}
