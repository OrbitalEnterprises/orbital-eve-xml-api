package enterprises.orbital.impl.evexmlapi.shared;

import java.util.Date;

import enterprises.orbital.evexmlapi.shared.IBookmark;

public class ApiBookmark implements IBookmark {

  private int    bookmarkID;
  private long   creatorID;
  private Date   created;
  private long   itemID;
  private int    typeID;
  private long   locationID;
  private double x;
  private double y;
  private double z;
  private String memo;
  private String note;

  @Override
  public int getBookmarkID() {
    return bookmarkID;
  }

  public void setBookmarkID(int bookmarkID) {
    this.bookmarkID = bookmarkID;
  }

  @Override
  public long getCreatorID() {
    return creatorID;
  }

  public void setCreatorID(long creatorID) {
    this.creatorID = creatorID;
  }

  @Override
  public Date getCreated() {
    return created;
  }

  public void setCreated(Date created) {
    this.created = created;
  }

  @Override
  public long getItemID() {
    return itemID;
  }

  public void setItemID(long itemID) {
    this.itemID = itemID;
  }

  @Override
  public int getTypeID() {
    return typeID;
  }

  public void setTypeID(int typeID) {
    this.typeID = typeID;
  }

  @Override
  public long getLocationID() {
    return locationID;
  }

  public void setLocationID(long locationID) {
    this.locationID = locationID;
  }

  @Override
  public double getX() {
    return x;
  }

  public void setX(double x) {
    this.x = x;
  }

  @Override
  public double getY() {
    return y;
  }

  public void setY(double y) {
    this.y = y;
  }

  @Override
  public double getZ() {
    return z;
  }

  public void setZ(double z) {
    this.z = z;
  }

  @Override
  public String getMemo() {
    return memo;
  }

  public void setMemo(String memo) {
    this.memo = memo;
  }

  @Override
  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

}