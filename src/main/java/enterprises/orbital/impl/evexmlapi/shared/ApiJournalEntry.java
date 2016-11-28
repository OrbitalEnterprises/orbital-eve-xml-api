package enterprises.orbital.impl.evexmlapi.shared;

import java.math.BigDecimal;
import java.util.Date;

import enterprises.orbital.evexmlapi.shared.IWalletJournalEntry;

public class ApiJournalEntry implements IWalletJournalEntry {
  private Date       date;
  private long       refID;
  private int        refTypeID;
  private String     ownerName1;
  private long       ownerID1;
  private String     ownerName2;
  private long       ownerID2;
  private String     argName1;
  private long       argID1;
  private BigDecimal amount;
  private BigDecimal balance;
  private String     reason;
  private long       taxReceiverID;
  private BigDecimal taxAmount;
  private int        owner1TypeID;
  private int        owner2TypeID;

  @Override
  public Date getDate() {
    return date;
  }

  public void setDate(
                      Date date) {
    this.date = date;
  }

  @Override
  public long getRefID() {
    return refID;
  }

  public void setRefID(
                       long refID) {
    this.refID = refID;
  }

  public void setRefTypeID(
                           int refTypeID) {
    this.refTypeID = refTypeID;
  }

  @Override
  public int getRefTypeID() {
    return refTypeID;
  }

  @Override
  public String getOwnerName1() {
    return ownerName1;
  }

  public void setOwnerName1(
                            String ownerName1) {
    this.ownerName1 = ownerName1;
  }

  @Override
  public long getOwnerID1() {
    return ownerID1;
  }

  public void setOwnerID1(
                          long ownerID1) {
    this.ownerID1 = ownerID1;
  }

  @Override
  public String getOwnerName2() {
    return ownerName2;
  }

  public void setOwnerName2(
                            String ownerName2) {
    this.ownerName2 = ownerName2;
  }

  @Override
  public long getOwnerID2() {
    return ownerID2;
  }

  public void setOwnerID2(
                          long ownerID2) {
    this.ownerID2 = ownerID2;
  }

  @Override
  public String getArgName1() {
    return argName1;
  }

  public void setArgName1(
                          String argName1) {
    this.argName1 = argName1;
  }

  @Override
  public long getArgID1() {
    return argID1;
  }

  public void setArgID1(
                        long argID1) {
    this.argID1 = argID1;
  }

  @Override
  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(
                        BigDecimal amount) {
    this.amount = amount;
  }

  @Override
  public BigDecimal getBalance() {
    return balance;
  }

  public void setBalance(
                         BigDecimal balance) {
    this.balance = balance;
  }

  @Override
  public String getReason() {
    return reason;
  }

  public void setReason(
                        String reason) {
    this.reason = reason;
  }

  @Override
  public long getTaxReceiverID() {
    return taxReceiverID;
  }

  public void setTaxReceiverID(
                               long taxReceiverID) {
    this.taxReceiverID = taxReceiverID;
  }

  @Override
  public BigDecimal getTaxAmount() {
    return taxAmount;
  }

  public void setTaxAmount(
                           BigDecimal taxAmount) {
    this.taxAmount = taxAmount;
  }

  @Override
  public int getOwner1TypeID() {
    return owner1TypeID;
  }

  public void setOwner1TypeID(
                              int owner1TypeID) {
    this.owner1TypeID = owner1TypeID;
  }

  @Override
  public int getOwner2TypeID() {
    return owner2TypeID;
  }

  public void setOwner2TypeID(
                              int owner2TypeID) {
    this.owner2TypeID = owner2TypeID;
  }

}