package enterprises.orbital.evexmlapi.crp;

public interface ICustomsOffice {
  public long getItemID();

  public int getSolarSystemID();

  public String getSolarSystemName();

  public int getReinforceHour();

  public boolean isAllowAlliance();

  public boolean isAllowStandings();

  public double getStandingLevel();

  public double getTaxRateAlliance();

  public double getTaxRateCorp();

  public double getTaxRateStandingHigh();

  public double getTaxRateStandingGood();

  public double getTaxRateStandingNeutral();

  public double getTaxRateStandingBad();

  public double getTaxRateStandingHorrible();

}
