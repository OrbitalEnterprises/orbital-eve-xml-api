package enterprises.orbital.impl.evexmlapi.shared;

import java.math.BigDecimal;
import java.util.Date;

import enterprises.orbital.evexmlapi.shared.IContract;

public class ApiContract implements IContract {
  private long       contractID;
  private long       issuerID;
  private long       issuerCorpID;
  private long       assigneeID;
  private long       acceptorID;
  private long       startStationID;
  private long       endStationID;
  private String     type;
  private String     status;
  private String     title;
  private boolean    forCorp;
  private String     availability;
  private Date       dateIssued;
  private Date       dateExpired;
  private Date       dateAccepted;
  private int        numDays;
  private Date       dateCompleted;
  private BigDecimal price;
  private BigDecimal reward;
  private BigDecimal collateral;
  private BigDecimal buyout;
  private double     volume;

  @Override
  public long getContractID() {
    return contractID;
  }

  public void setContractID(
                            long contractID) {
    this.contractID = contractID;
  }

  @Override
  public long getIssuerID() {
    return issuerID;
  }

  public void setIssuerID(
                          long issuerID) {
    this.issuerID = issuerID;
  }

  @Override
  public long getIssuerCorpID() {
    return issuerCorpID;
  }

  public void setIssuerCorpID(
                              long issuerCorpID) {
    this.issuerCorpID = issuerCorpID;
  }

  @Override
  public long getAssigneeID() {
    return assigneeID;
  }

  public void setAssigneeID(
                            long assigneeID) {
    this.assigneeID = assigneeID;
  }

  @Override
  public long getAcceptorID() {
    return acceptorID;
  }

  public void setAcceptorID(
                            long acceptorID) {
    this.acceptorID = acceptorID;
  }

  @Override
  public long getStartStationID() {
    return startStationID;
  }

  public void setStartStationID(
                                long startStationID) {
    this.startStationID = startStationID;
  }

  @Override
  public long getEndStationID() {
    return endStationID;
  }

  public void setEndStationID(
                              long endStationID) {
    this.endStationID = endStationID;
  }

  @Override
  public String getType() {
    return type;
  }

  public void setType(
                      String type) {
    this.type = type;
  }

  @Override
  public String getStatus() {
    return status;
  }

  public void setStatus(
                        String status) {
    this.status = status;
  }

  @Override
  public String getTitle() {
    return title;
  }

  public void setTitle(
                       String title) {
    this.title = title;
  }

  @Override
  public boolean isForCorp() {
    return forCorp;
  }

  public void setForCorp(
                         boolean forCorp) {
    this.forCorp = forCorp;
  }

  @Override
  public String getAvailability() {
    return availability;
  }

  public void setAvailability(
                              String availability) {
    this.availability = availability;
  }

  @Override
  public Date getDateIssued() {
    return dateIssued;
  }

  public void setDateIssued(
                            Date dateIssued) {
    this.dateIssued = dateIssued;
  }

  @Override
  public Date getDateExpired() {
    return dateExpired;
  }

  public void setDateExpired(
                             Date dateExpired) {
    this.dateExpired = dateExpired;
  }

  @Override
  public Date getDateAccepted() {
    return dateAccepted;
  }

  public void setDateAccepted(
                              Date dateAccepted) {
    this.dateAccepted = dateAccepted;
  }

  @Override
  public int getNumDays() {
    return numDays;
  }

  public void setNumDays(
                         int numDays) {
    this.numDays = numDays;
  }

  @Override
  public Date getDateCompleted() {
    return dateCompleted;
  }

  public void setDateCompleted(
                               Date dateCompleted) {
    this.dateCompleted = dateCompleted;
  }

  @Override
  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(
                       BigDecimal price) {
    this.price = price;
  }

  @Override
  public BigDecimal getReward() {
    return reward;
  }

  public void setReward(
                        BigDecimal reward) {
    this.reward = reward;
  }

  @Override
  public BigDecimal getCollateral() {
    return collateral;
  }

  public void setCollateral(
                            BigDecimal collateral) {
    this.collateral = collateral;
  }

  @Override
  public BigDecimal getBuyout() {
    return buyout;
  }

  public void setBuyout(
                        BigDecimal buyout) {
    this.buyout = buyout;
  }

  @Override
  public double getVolume() {
    return volume;
  }

  public void setVolume(
                        double volume) {
    this.volume = volume;
  }

}