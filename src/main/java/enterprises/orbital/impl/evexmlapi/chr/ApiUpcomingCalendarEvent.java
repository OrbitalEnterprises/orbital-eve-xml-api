package enterprises.orbital.impl.evexmlapi.chr;

import java.util.Date;

import enterprises.orbital.evexmlapi.chr.IUpcomingCalendarEvent;

public class ApiUpcomingCalendarEvent implements IUpcomingCalendarEvent {
  private long    eventID;
  private long    ownerID;
  private String  ownerName;
  private Date    eventDate;
  private String  eventTitle;
  private int     duration;
  private boolean important;
  private String  response;
  private String  eventText;
  private int     ownerTypeID;

  @Override
  public long getEventID() {
    return eventID;
  }

  public void setEventID(
                         long eventID) {
    this.eventID = eventID;
  }

  @Override
  public long getOwnerID() {
    return ownerID;
  }

  public void setOwnerID(
                         long ownerID) {
    this.ownerID = ownerID;
  }

  @Override
  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(
                           String ownerName) {
    this.ownerName = ownerName;
  }

  @Override
  public Date getEventDate() {
    return eventDate;
  }

  public void setEventDate(
                           Date eventDate) {
    this.eventDate = eventDate;
  }

  @Override
  public String getEventTitle() {
    return eventTitle;
  }

  public void setEventTitle(
                            String eventTitle) {
    this.eventTitle = eventTitle;
  }

  @Override
  public int getDuration() {
    return duration;
  }

  public void setDuration(
                          int duration) {
    this.duration = duration;
  }

  @Override
  public boolean isImportant() {
    return important;
  }

  public void setImportance(
                            int importance) {
    this.important = importance == 1;
  }

  @Override
  public String getResponse() {
    return response;
  }

  public void setResponse(
                          String response) {
    this.response = response;
  }

  @Override
  public String getEventText() {
    return eventText;
  }

  public void setEventText(
                           String eventText) {
    this.eventText = eventText;
  }

  @Override
  public int getOwnerTypeID() {
    return ownerTypeID;
  }

  public void setOwnerTypeID(
                             int ownerTypeID) {
    this.ownerTypeID = ownerTypeID;
  }

}