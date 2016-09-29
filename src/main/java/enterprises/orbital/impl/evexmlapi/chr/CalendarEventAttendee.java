package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.evexmlapi.chr.ICalendarEventAttendee;

public class CalendarEventAttendee implements ICalendarEventAttendee {
  private long   eventID;
  private long   characterID;
  private String characterName;
  private String response;

  @Override
  public long getCharacterID() {
    return characterID;
  }

  @Override
  public long getEventID() {
    return eventID;
  }

  public void setEventID(
                         long eventID) {
    this.eventID = eventID;
  }

  public void setCharacterID(
                             long characterID) {
    this.characterID = characterID;
  }

  @Override
  public String getCharacterName() {
    return characterName;
  }

  public void setCharacterName(
                               String characterName) {
    this.characterName = characterName;
  }

  @Override
  public String getResponse() {
    return response;
  }

  public void setResponse(
                          String response) {
    this.response = response;
  }
}
