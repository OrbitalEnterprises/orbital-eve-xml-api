package enterprises.orbital.impl.evexmlapi.shared;

import enterprises.orbital.evexmlapi.shared.IContact;
import enterprises.orbital.evexmlapi.shared.IContactLabel;

public class ApiContact implements IContact, IContactLabel {
  private int     contactID;
  private String  contactName;
  private double  standing;
  private int     contactTypeID;
  private boolean inWatchlist;
  private long    labelMask;

  // These two fields will only appear in contact Labels
  // We're slightly abusing the parser here but this simplifies handling.
  private long    labelID;
  private String  name;

  public void setContactID(int fromID) {
    this.contactID = fromID;
  }

  public void setContactName(String fromName) {
    this.contactName = fromName;
  }

  public void setStanding(double standing) {
    this.standing = standing;
  }

  @Override
  public int getContactTypeID() {
    return contactTypeID;
  }

  public void setContactTypeID(int contactTypeID) {
    this.contactTypeID = contactTypeID;
  }

  @Override
  public int getContactID() {
    return this.contactID;
  }

  @Override
  public String getContactName() {
    return this.contactName;
  }

  @Override
  public double getStanding() {
    return this.standing;
  }

  @Override
  public boolean isInWatchlist() {
    return inWatchlist;
  }

  public void setInWatchlist(boolean inWatchlist) {
    this.inWatchlist = inWatchlist;
  }

  @Override
  public long getLabelMask() {
    return labelMask;
  }

  public void setLabelMask(long labelMask) {
    this.labelMask = labelMask;
  }

  public long getLabelID() {
    return labelID;
  }

  public void setLabelID(long labelID) {
    this.labelID = labelID;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}