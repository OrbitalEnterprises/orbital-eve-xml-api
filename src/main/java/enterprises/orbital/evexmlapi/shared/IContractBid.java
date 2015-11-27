package enterprises.orbital.evexmlapi.shared;

import java.math.BigDecimal;
import java.util.Date;

public interface IContractBid {

  public long getBidID();

  public long getContractID();

  public long getBidderID();

  public Date getDateBid();

  public BigDecimal getAmount();

}
