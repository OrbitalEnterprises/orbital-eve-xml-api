package enterprises.orbital.impl.evexmlapi.chr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.chr.IUpcomingCalendarEvent;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class UpcomingCalendarEventsParser extends AbstractApiParser<UpcomingCalendarEventsResponse, Collection<IUpcomingCalendarEvent>> {
  public UpcomingCalendarEventsParser() {
    super(UpcomingCalendarEventsResponse.class, ApiEndpoint.CHR_UPCOMING_CALENDAR_EVENTS_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiUpcomingCalendarEvent.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "add");
    return digester;
  }

  @Override
  public Collection<IUpcomingCalendarEvent> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    UpcomingCalendarEventsResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IUpcomingCalendarEvent> result = new ArrayList<IUpcomingCalendarEvent>();
    result.addAll(response.getUpcomingCalendarEvents());
    return result;
  }

}