package enterprises.orbital.impl.evexmlapi.chr;

import java.util.ArrayList;
import java.util.List;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class UpcomingCalendarEventsResponse extends ApiResponse {
  private static final long                    serialVersionUID       = -166965924934757283L;
  private final List<ApiUpcomingCalendarEvent> upcomingCalendarEvents = new ArrayList<ApiUpcomingCalendarEvent>();

  public void add(ApiUpcomingCalendarEvent event) {
    upcomingCalendarEvents.add(event);
  }

  public List<ApiUpcomingCalendarEvent> getUpcomingCalendarEvents() {
    return upcomingCalendarEvents;
  }
}