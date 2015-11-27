package enterprises.orbital.impl.evexmlapi.crp;

import enterprises.orbital.evexmlapi.crp.ICustomsOffice;

public class ApiCustomsOffice implements ICustomsOffice {
  private long    itemID;
  private int     solarSystemID;
  private String  solarSystemName;
  private int     reinforceHour;
  private boolean allowAlliance;
  private boolean allowStandings;
  private double  standingLevel;
  private double  taxRateAlliance;
  private double  taxRateCorp;
  private double  taxRateStandingHigh;
  private double  taxRateStandingGood;
  private double  taxRateStandingNeutral;
  private double  taxRateStandingBad;
  private double  taxRateStandingHorrible;

  public long getItemID() {
    return itemID;
  }

  public void setItemID(long itemID) {
    this.itemID = itemID;
  }

  public int getSolarSystemID() {
    return solarSystemID;
  }

  public void setSolarSystemID(int solarSystemID) {
    this.solarSystemID = solarSystemID;
  }

  public String getSolarSystemName() {
    return solarSystemName;
  }

  public void setSolarSystemName(String solarSystemName) {
    this.solarSystemName = solarSystemName;
  }

  public int getReinforceHour() {
    return reinforceHour;
  }

  public void setReinforceHour(int reinforceHour) {
    this.reinforceHour = reinforceHour;
  }

  public boolean isAllowAlliance() {
    return allowAlliance;
  }

  public void setAllowAlliance(boolean allowAlliance) {
    this.allowAlliance = allowAlliance;
  }

  public boolean isAllowStandings() {
    return allowStandings;
  }

  public void setAllowStandings(boolean allowStandings) {
    this.allowStandings = allowStandings;
  }

  public double getStandingLevel() {
    return standingLevel;
  }

  public void setStandingLevel(double standingLevel) {
    this.standingLevel = standingLevel;
  }

  public double getTaxRateAlliance() {
    return taxRateAlliance;
  }

  public void setTaxRateAlliance(double taxRateAlliance) {
    this.taxRateAlliance = taxRateAlliance;
  }

  public double getTaxRateCorp() {
    return taxRateCorp;
  }

  public void setTaxRateCorp(double taxRateCorp) {
    this.taxRateCorp = taxRateCorp;
  }

  public double getTaxRateStandingHigh() {
    return taxRateStandingHigh;
  }

  public void setTaxRateStandingHigh(double taxRateStandingHigh) {
    this.taxRateStandingHigh = taxRateStandingHigh;
  }

  public double getTaxRateStandingGood() {
    return taxRateStandingGood;
  }

  public void setTaxRateStandingGood(double taxRateStandingGood) {
    this.taxRateStandingGood = taxRateStandingGood;
  }

  public double getTaxRateStandingNeutral() {
    return taxRateStandingNeutral;
  }

  public void setTaxRateStandingNeutral(double taxRateStandingNeutral) {
    this.taxRateStandingNeutral = taxRateStandingNeutral;
  }

  public double getTaxRateStandingBad() {
    return taxRateStandingBad;
  }

  public void setTaxRateStandingBad(double taxRateStandingBad) {
    this.taxRateStandingBad = taxRateStandingBad;
  }

  public double getTaxRateStandingHorrible() {
    return taxRateStandingHorrible;
  }

  public void setTaxRateStandingHorrible(double taxRateStandingHorrible) {
    this.taxRateStandingHorrible = taxRateStandingHorrible;
  }

}