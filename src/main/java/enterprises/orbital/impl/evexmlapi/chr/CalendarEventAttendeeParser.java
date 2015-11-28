package enterprises.orbital.impl.evexmlapi.chr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.chr.ICalendarEventAttendee;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiAuth;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class CalendarEventAttendeeParser extends AbstractApiParser<CalendarEventAttendeeResponse, Collection<ICalendarEventAttendee>> {
  protected int[] events;

  public CalendarEventAttendeeParser(ApiConnector connector, int... events) {
    super(connector, CalendarEventAttendeeResponse.class, ApiEndpoint.CHR_CALENDAR_EVENT_ATTENDEE_V2);
    this.events = events;
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();

    CalendarEventAttendeeFactory rowFactory = new CalendarEventAttendeeFactory();
    digester.addFactoryCreate("eveapi/result/rowset/row", rowFactory);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addAttendee");

    return digester;
  }

  public CalendarEventAttendeeResponse getResponseWithEvents(ApiAuth auth) throws IOException {
    if (events.length > 0) {
      String eventString = Arrays.toString(events).replace("[", "").replace("]", "").replace(" ", "");
      return getResponse(auth, "eventIDs", eventString);
    }
    return getResponse(auth);
  }

  @Override
  public Collection<ICalendarEventAttendee> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    CalendarEventAttendeeResponse response = getResponseWithEvents(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<ICalendarEventAttendee> result = new ArrayList<ICalendarEventAttendee>();
    result.addAll(response.getAttendees());
    return result;
  }
}
