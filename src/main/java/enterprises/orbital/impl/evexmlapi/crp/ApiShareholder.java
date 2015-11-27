package enterprises.orbital.impl.evexmlapi.crp;

import enterprises.orbital.evexmlapi.crp.IShareholder;

public class ApiShareholder implements IShareholder {
  private long   shareholderID;
  private String shareholderName;
  private long   shareholderCorporationID;
  private String shareholderCorporationName;
  private int    shares;

  @Override
  public long getShareholderID() {
    return shareholderID;
  }

  public void setShareholderID(long shareholderID) {
    this.shareholderID = shareholderID;
  }

  @Override
  public String getShareholderName() {
    return shareholderName;
  }

  public void setShareholderName(String shareholderName) {
    this.shareholderName = shareholderName;
  }

  @Override
  public long getShareholderCorporationID() {
    return shareholderCorporationID;
  }

  public void setShareholderCorporationID(long shareholderCorporationID) {
    this.shareholderCorporationID = shareholderCorporationID;
  }

  @Override
  public String getShareholderCorporationName() {
    return shareholderCorporationName;
  }

  public void setShareholderCorporationName(String shareholderCorporationName) {
    this.shareholderCorporationName = shareholderCorporationName;
  }

  @Override
  public int getShares() {
    return shares;
  }

  public void setShares(int shares) {
    this.shares = shares;
  }

  @Override
  public boolean isCorporation() {
    return shareholderCorporationName == null;
  }
}