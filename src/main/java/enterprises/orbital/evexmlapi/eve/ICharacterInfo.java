package enterprises.orbital.evexmlapi.eve;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(
    as = ICharacterInfo.class)
public interface ICharacterInfo {
  public BigDecimal getAccountBalance();

  public String getAlliance();

  public Date getAllianceDate();

  public long getAllianceID();

  public String getBloodline();

  public long getCharacterID();

  public String getCharacterName();

  public String getCorporation();

  public Date getCorporationDate();

  public long getCorporationID();

  public String getLastKnownLocation();

  public String getRace();

  public double getSecurityStatus();

  public Collection<IEmploymentHistory> getEmploymentHistory();

  public String getShipName();

  public int getShipTypeID();

  public String getShipTypeName();

  public int getSkillPoints();
}
