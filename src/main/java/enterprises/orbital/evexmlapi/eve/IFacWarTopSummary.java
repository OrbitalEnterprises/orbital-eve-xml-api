package enterprises.orbital.evexmlapi.eve;

public interface IFacWarTopSummary {
	public IFacWarTopStats<ICharacterKillStat, ICharacterVictoryPointStat> getCharacterStats();

	public IFacWarTopStats<ICorporationKillStat, ICorporationVictoryPointStat> getCorporationStats();

	public IFacWarTopStats<IFactionKillStat, IFactionVictoryPointStat> getFactionStats();
}
