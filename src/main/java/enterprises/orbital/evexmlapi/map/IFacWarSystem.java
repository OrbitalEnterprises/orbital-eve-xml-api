package enterprises.orbital.evexmlapi.map;

public interface IFacWarSystem {
	public int getOccupyingFactionID();

	public String getOccupyingFactionName();

	public int getOwningFactionID();

	public String getOwningFactionName();

	public int getSolarSystemID();

	public String getSolarSystemName();

	public boolean isContested();
}
