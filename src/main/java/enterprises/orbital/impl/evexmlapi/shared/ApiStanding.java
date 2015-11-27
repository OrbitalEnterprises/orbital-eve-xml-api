package enterprises.orbital.impl.evexmlapi.shared;

import enterprises.orbital.evexmlapi.shared.IStanding;

public class ApiStanding implements IStanding {
  private int    fromID;
  private String fromName;
  private double standing;

  public void setFromID(int fromID) {
    this.fromID = fromID;
  }

  public void setFromName(String fromName) {
    this.fromName = fromName;
  }

  public void setStanding(double standing) {
    this.standing = standing;
  }

  @Override
  public int getFromID() {
    return this.fromID;
  }

  @Override
  public String getFromName() {
    return this.fromName;
  }

  @Override
  public double getStanding() {
    return this.standing;
  }
}