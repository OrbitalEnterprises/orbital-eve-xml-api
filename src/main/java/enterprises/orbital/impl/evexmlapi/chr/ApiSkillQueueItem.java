package enterprises.orbital.impl.evexmlapi.chr;

import java.util.Date;

import enterprises.orbital.evexmlapi.chr.ISkillInQueue;

public class ApiSkillQueueItem implements ISkillInQueue {
  private int  queuePosition;
  private int  typeID;
  private int  level;
  private int  startSP;
  private int  endSP;
  private Date startTime;
  private Date endTime;

  @Override
  public int getQueuePosition() {
    return queuePosition;
  }

  public void setQueuePosition(int queuePosition) {
    this.queuePosition = queuePosition;
  }

  @Override
  public int getTypeID() {
    return typeID;
  }

  public void setTypeID(int typeID) {
    this.typeID = typeID;
  }

  @Override
  public int getLevel() {
    return level;
  }

  public void setLevel(int level) {
    this.level = level;
  }

  @Override
  public int getStartSP() {
    return startSP;
  }

  public void setStartSP(int startSP) {
    this.startSP = startSP;
  }

  @Override
  public int getEndSP() {
    return endSP;
  }

  public void setEndSP(int endSP) {
    this.endSP = endSP;
  }

  @Override
  public Date getStartTime() {
    return startTime;
  }

  public void setStartTime(Date startTime) {
    this.startTime = startTime;
  }

  @Override
  public Date getEndTime() {
    return endTime;
  }

  public void setEndTime(Date endTime) {
    this.endTime = endTime;
  }
}