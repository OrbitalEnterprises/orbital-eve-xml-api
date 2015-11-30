package enterprises.orbital.evexmlapi.crp;

public interface IShareholder {
	/**
	 * If true then the shareholder is a corporation with ID and name
	 * retrievable with getShareholderID and getShareholderName. In this case,
	 * getSharholderCorporationID and getShareholderCorporationName will return
	 * undefined values. If false, then the shareholder is an individual
	 * character and all fields will have valid data.
	 * 
	 * @return true if shareholder is a corporation.
	 */
	public boolean isCorporation();

	public long getShareholderCorporationID();

	public String getShareholderCorporationName();

	public long getShareholderID();

	public String getShareholderName();

	public int getShares();
}
