package enterprises.orbital.impl.evexmlapi.shared;

import java.math.BigDecimal;
import java.util.Date;

import enterprises.orbital.evexmlapi.shared.IContractBid;

public class ApiContractBid implements IContractBid {
  private long       bidID;
  private long       contractID;
  private long       bidderID;
  private Date       dateBid;
  private BigDecimal amount;

  @Override
  public long getBidID() {
    return bidID;
  }

  public void setBidID(long bidID) {
    this.bidID = bidID;
  }

  @Override
  public long getContractID() {
    return contractID;
  }

  public void setContractID(long contractID) {
    this.contractID = contractID;
  }

  @Override
  public long getBidderID() {
    return bidderID;
  }

  public void setBidderID(long bidderID) {
    this.bidderID = bidderID;
  }

  @Override
  public Date getDateBid() {
    return dateBid;
  }

  public void setDateBid(Date dateBid) {
    this.dateBid = dateBid;
  }

  @Override
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

}