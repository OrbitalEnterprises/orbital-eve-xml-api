package enterprises.orbital.evexmlapi.crp;

import java.util.Collection;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = ICorporationSheet.class)
public interface ICorporationSheet {
  public long getAllianceID();

  public String getAllianceName();

  public long getCeoID();

  public String getCeoName();

  public long getCorporationID();

  public String getCorporationName();

  public String getDescription();

  public Collection<IDivision> getDivisions();

  public int getLogoColor1();

  public int getLogoColor2();

  public int getLogoColor3();

  public int getLogoGraphicID();

  public int getLogoShape1();

  public int getLogoShape2();

  public int getLogoShape3();

  public int getMemberCount();

  public int getMemberLimit();

  public int getShares();

  public long getStationID();

  public String getStationName();

  public double getTaxRate();

  public String getTicker();

  public String getUrl();

  public Collection<IDivision> getWalletDivisions();
}
