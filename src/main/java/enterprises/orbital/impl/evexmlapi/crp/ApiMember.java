package enterprises.orbital.impl.evexmlapi.crp;

import java.util.Date;

import enterprises.orbital.evexmlapi.crp.IMemberTracking;

public class ApiMember implements IMemberTracking {
  private long   characterID;
  private String name;
  private Date   startDateTime;
  private int    baseID;
  private String base;
  private String title;
  private Date   logonDateTime;
  private Date   logoffDateTime;
  private int    locationID;
  private String location;
  private int    shipTypeID;
  private String shipType;
  private long   roles;
  private long   grantableRoles;

  @Override
  public long getCharacterID() {
    return characterID;
  }

  public void setCharacterID(long characterID) {
    this.characterID = characterID;
  }

  @Override
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public Date getStartDateTime() {
    return startDateTime;
  }

  public void setStartDateTime(Date startDateTime) {
    this.startDateTime = startDateTime;
  }

  @Override
  public int getBaseID() {
    return baseID;
  }

  public void setBaseID(int baseID) {
    this.baseID = baseID;
  }

  @Override
  public String getBase() {
    return base;
  }

  public void setBase(String base) {
    this.base = base;
  }

  @Override
  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  @Override
  public Date getLogonDateTime() {
    return logonDateTime;
  }

  public void setLogonDateTime(Date logonDateTime) {
    this.logonDateTime = logonDateTime;
  }

  @Override
  public Date getLogoffDateTime() {
    return logoffDateTime;
  }

  public void setLogoffDateTime(Date logoffDateTime) {
    this.logoffDateTime = logoffDateTime;
  }

  @Override
  public int getLocationID() {
    return locationID;
  }

  public void setLocationID(int locationID) {
    this.locationID = locationID;
  }

  @Override
  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  @Override
  public int getShipTypeID() {
    return shipTypeID;
  }

  public void setShipTypeID(int shipTypeID) {
    this.shipTypeID = shipTypeID;
  }

  @Override
  public String getShipType() {
    return shipType;
  }

  public void setShipType(String shipType) {
    this.shipType = shipType;
  }

  @Override
  public long getRoles() {
    return roles;
  }

  public void setRoles(long roles) {
    this.roles = roles;
  }

  @Override
  public long getGrantableRoles() {
    return grantableRoles;
  }

  public void setGrantableRoles(long grantableRoles) {
    this.grantableRoles = grantableRoles;
  }
}
