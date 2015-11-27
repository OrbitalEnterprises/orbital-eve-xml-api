package enterprises.orbital.evexmlapi.shared;


public interface IKillAttacker {
	public long getAllianceID();

	public String getAllianceName();

	public long getCharacterID();

	public String getCharacterName();

	public long getCorporationID();

	public String getCorporationName();

	public int getDamageDone();

	public int getFactionID();

	public String getFactionName();

	public double getSecurityStatus();

	public int getShipTypeID();

	public int getWeaponTypeID();

	public boolean isFinalBlow();
}
