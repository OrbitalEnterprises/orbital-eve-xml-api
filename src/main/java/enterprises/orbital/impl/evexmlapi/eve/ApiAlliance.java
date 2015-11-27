package enterprises.orbital.impl.evexmlapi.eve;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import enterprises.orbital.evexmlapi.eve.IAlliance;
import enterprises.orbital.evexmlapi.eve.IMemberCorporation;

public class ApiAlliance implements IAlliance {
  private String                               name;
  private String                               shortName;
  private long                                 allianceID;
  private long                                 executorCorpID;
  private int                                  memberCount;
  private Date                                 startDate;
  private final Collection<IMemberCorporation> memberCorporations = new ArrayList<IMemberCorporation>();

  @Override
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String getShortName() {
    return shortName;
  }

  public void setShortName(String shortName) {
    this.shortName = shortName;
  }

  @Override
  public long getAllianceID() {
    return allianceID;
  }

  public void setAllianceID(long allianceID) {
    this.allianceID = allianceID;
  }

  @Override
  public long getExecutorCorpID() {
    return executorCorpID;
  }

  public void setExecutorCorpID(long executorCorpID) {
    this.executorCorpID = executorCorpID;
  }

  @Override
  public int getMemberCount() {
    return memberCount;
  }

  public void setMemberCount(int memberCount) {
    this.memberCount = memberCount;
  }

  @Override
  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public void addMemberCorporation(ApiMemberCorporation memberCorporation) {
    memberCorporations.add(memberCorporation);
  }

  @Override
  public Collection<IMemberCorporation> getMemberCorporations() {
    return memberCorporations;
  }
}