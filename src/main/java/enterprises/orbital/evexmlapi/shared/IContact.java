package enterprises.orbital.evexmlapi.shared;


public interface IContact {
  public int getContactID();

  public String getContactName();

  public double getStanding();

  public int getContactTypeID();

  /**
   * True if this is a "character" contact in the watchlist and false otherwise. Note that for non-character contacts, this function will always return false.
   * 
   * @return true if this is a "character" contact in the watchlist, false otherwise.
   */
  public boolean isInWatchlist();

  public long getLabelMask();
}
