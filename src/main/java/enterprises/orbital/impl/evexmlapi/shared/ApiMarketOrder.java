package enterprises.orbital.impl.evexmlapi.shared;

import java.math.BigDecimal;
import java.util.Date;

import enterprises.orbital.evexmlapi.shared.IMarketOrder;

public class ApiMarketOrder implements IMarketOrder {
  private long       orderID;
  private long       charID;
  private long       stationID;
  private int        volEntered;
  private int        volRemaining;
  private int        minVolume;
  private int        orderState;
  private int        typeID;
  private int        range;
  private int        accountKey;
  private int        duration;
  private BigDecimal escrow;
  private BigDecimal price;
  private int        bid;
  private Date       issued;

  @Override
  public long getOrderID() {
    return orderID;
  }

  public void setOrderID(long orderID) {
    this.orderID = orderID;
  }

  @Override
  public long getCharID() {
    return charID;
  }

  public void setCharID(long charID) {
    this.charID = charID;
  }

  @Override
  public long getStationID() {
    return stationID;
  }

  public void setStationID(long stationID) {
    this.stationID = stationID;
  }

  @Override
  public int getVolEntered() {
    return volEntered;
  }

  public void setVolEntered(int volEntered) {
    this.volEntered = volEntered;
  }

  @Override
  public int getVolRemaining() {
    return volRemaining;
  }

  public void setVolRemaining(int volRemaining) {
    this.volRemaining = volRemaining;
  }

  @Override
  public int getMinVolume() {
    return minVolume;
  }

  public void setMinVolume(int minVolume) {
    this.minVolume = minVolume;
  }

  @Override
  public int getOrderState() {
    return orderState;
  }

  public void setOrderState(int orderState) {
    this.orderState = orderState;
  }

  @Override
  public int getTypeID() {
    return typeID;
  }

  public void setTypeID(int typeID) {
    this.typeID = typeID;
  }

  @Override
  public int getRange() {
    return range;
  }

  public void setRange(int range) {
    this.range = range;
  }

  @Override
  public int getAccountKey() {
    return accountKey;
  }

  public void setAccountKey(int accountKey) {
    this.accountKey = accountKey;
  }

  @Override
  public int getDuration() {
    return duration;
  }

  public void setDuration(int duration) {
    this.duration = duration;
  }

  @Override
  public BigDecimal getEscrow() {
    return escrow;
  }

  public void setEscrow(BigDecimal escrow) {
    this.escrow = escrow;
  }

  @Override
  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  @Override
  public int getBid() {
    return bid;
  }

  public void setBid(int bid) {
    this.bid = bid;
  }

  @Override
  public Date getIssued() {
    return issued;
  }

  public void setIssued(Date issued) {
    this.issued = issued;
  }
}