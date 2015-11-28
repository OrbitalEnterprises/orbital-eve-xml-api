package enterprises.orbital.impl.evexmlapi.act;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import enterprises.orbital.evexmlapi.act.IAccountStatus;
import enterprises.orbital.evexmlapi.act.IMultiCharacterTraining;
import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class AccountStatusResponse extends ApiResponse implements IAccountStatus {
  private Date                                  paidUntil;
  private Date                                  createDate;
  private int                                   logonCount;
  private int                                   logonMinutes;
  private final List<ApiMultiCharacterTraining> multiCharacterTraining = new ArrayList<ApiMultiCharacterTraining>();

  public void addMultiCharacterTraining(ApiMultiCharacterTraining training) {
    multiCharacterTraining.add(training);
  }

  @Override
  public List<IMultiCharacterTraining> getMultiCharacterTraining() {
    List<IMultiCharacterTraining> result = new ArrayList<IMultiCharacterTraining>();
    result.addAll(multiCharacterTraining);
    return result;
  }

  @Override
  public Date getPaidUntil() {
    return paidUntil;
  }

  public void setPaidUntil(Date paidUntil) {
    this.paidUntil = paidUntil;
  }

  @Override
  public Date getCreateDate() {
    return createDate;
  }

  public void setCreateDate(Date createDate) {
    this.createDate = createDate;
  }

  @Override
  public int getLogonCount() {
    return logonCount;
  }

  public void setLogonCount(int logonCount) {
    this.logonCount = logonCount;
  }

  @Override
  public int getLogonMinutes() {
    return logonMinutes;
  }

  public void setLogonMinutes(int logonMinutes) {
    this.logonMinutes = logonMinutes;
  }
}