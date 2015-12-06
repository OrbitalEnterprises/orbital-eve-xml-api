package enterprises.orbital.evexmlapi.eve;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IFacWarTopSummary.class)
public interface IFacWarTopSummary {
  public IFacWarTopStats<ICharacterKillStat, ICharacterVictoryPointStat> getCharacterStats();

  public IFacWarTopStats<ICorporationKillStat, ICorporationVictoryPointStat> getCorporationStats();

  public IFacWarTopStats<IFactionKillStat, IFactionVictoryPointStat> getFactionStats();
}
