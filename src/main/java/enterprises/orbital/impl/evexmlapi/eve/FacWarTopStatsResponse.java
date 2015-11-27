package enterprises.orbital.impl.evexmlapi.eve;

import enterprises.orbital.evexmlapi.eve.IFacWarTopSummary;
import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class FacWarTopStatsResponse extends ApiResponse implements IFacWarTopSummary {
  private static final long serialVersionUID = 5798201679959207218L;
  private CharacterStats    characterStats;
  private CorporationStats  corporationStats;
  private FactionStats      factionStats;

  @Override
  public CharacterStats getCharacterStats() {
    return characterStats;
  }

  public void setCharacterStats(CharacterStats characterStats) {
    this.characterStats = characterStats;
  }

  @Override
  public CorporationStats getCorporationStats() {
    return corporationStats;
  }

  public void setCorporationStats(CorporationStats corporationStats) {
    this.corporationStats = corporationStats;
  }

  @Override
  public FactionStats getFactionStats() {
    return factionStats;
  }

  public void setFactionStats(FactionStats factionStats) {
    this.factionStats = factionStats;
  }

}