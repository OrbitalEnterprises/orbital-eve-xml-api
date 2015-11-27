package enterprises.orbital.impl.evexmlapi.shared;

import java.math.BigDecimal;
import java.util.Date;

import enterprises.orbital.evexmlapi.shared.IWalletTransaction;

public class ApiWalletTransaction implements IWalletTransaction {
  private Date       transactionDateTime;
  private long       transactionID;
  private long       quantity;
  private String     typeName;
  private long       typeID;
  private BigDecimal price;
  private long       clientID;
  private String     clientName;
  private long       characterID;
  private String     characterName;
  private long       stationID;
  private String     stationName;
  private String     transactionType;
  private String     transactionFor;
  private long       journalTransactionID;

  @Override
  public long getJournalTransactionID() {
    return journalTransactionID;
  }

  public void setJournalTransactionID(long journalTransactionID) {
    this.journalTransactionID = journalTransactionID;
  }

  @Override
  public Date getTransactionDateTime() {
    return transactionDateTime;
  }

  public void setTransactionDateTime(Date transactionDateTime) {
    this.transactionDateTime = transactionDateTime;
  }

  @Override
  public long getTransactionID() {
    return transactionID;
  }

  public void setTransactionID(long transactionID) {
    this.transactionID = transactionID;
  }

  @Override
  public long getQuantity() {
    return quantity;
  }

  public void setQuantity(long quantity) {
    this.quantity = quantity;
  }

  @Override
  public String getTypeName() {
    return typeName;
  }

  public void setTypeName(String typeName) {
    this.typeName = typeName;
  }

  @Override
  public long getTypeID() {
    return typeID;
  }

  public void setTypeID(long typeID) {
    this.typeID = typeID;
  }

  @Override
  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  @Override
  public long getClientID() {
    return clientID;
  }

  public void setClientID(long clientID) {
    this.clientID = clientID;
  }

  @Override
  public String getClientName() {
    return clientName;
  }

  public void setClientName(String clientName) {
    this.clientName = clientName;
  }

  @Override
  public long getCharacterID() {
    return characterID;
  }

  public void setCharacterID(long characterID) {
    this.characterID = characterID;
  }

  @Override
  public String getCharacterName() {
    return characterName;
  }

  public void setCharacterName(String characterName) {
    this.characterName = characterName;
  }

  @Override
  public long getStationID() {
    return stationID;
  }

  public void setStationID(long stationID) {
    this.stationID = stationID;
  }

  @Override
  public String getStationName() {
    return stationName;
  }

  public void setStationName(String stationName) {
    this.stationName = stationName;
  }

  @Override
  public String getTransactionType() {
    return transactionType;
  }

  public void setTransactionType(String transactionType) {
    this.transactionType = transactionType;
  }

  @Override
  public String getTransactionFor() {
    return transactionFor;
  }

  public void setTransactionFor(String transactionFor) {
    this.transactionFor = transactionFor;
  }

}
