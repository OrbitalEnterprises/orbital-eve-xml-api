package enterprises.orbital.evexmlapi.shared;

import java.math.BigDecimal;
import java.util.Date;

public interface IMarketOrder {

  public int getAccountKey();

  public int getBid();

  public long getCharID();

  public int getDuration();

  public BigDecimal getEscrow();

  public Date getIssued();

  public int getMinVolume();

  public long getOrderID();

  public int getOrderState();

  public BigDecimal getPrice();

  public int getRange();

  public long getStationID();

  public int getTypeID();

  public int getVolEntered();

  public int getVolRemaining();
}
