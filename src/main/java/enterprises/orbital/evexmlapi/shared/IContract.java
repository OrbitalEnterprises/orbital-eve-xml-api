package enterprises.orbital.evexmlapi.shared;

import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IContract.class)
public interface IContract {

  public long getContractID();

  public long getIssuerID();

  public long getIssuerCorpID();

  public long getAssigneeID();

  public long getAcceptorID();

  public int getStartStationID();

  public int getEndStationID();

  public String getType();

  public String getStatus();

  public String getTitle();

  public boolean isForCorp();

  public String getAvailability();

  public Date getDateIssued();

  public Date getDateExpired();

  public Date getDateAccepted();

  public int getNumDays();

  public Date getDateCompleted();

  public BigDecimal getPrice();

  public BigDecimal getReward();

  public BigDecimal getCollateral();

  public BigDecimal getBuyout();

  public long getVolume();

}
