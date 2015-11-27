package enterprises.orbital.impl.evexmlapi.chr;

import java.util.Date;

import enterprises.orbital.evexmlapi.chr.IChatChannelMember;

public class ApiChatChannelMember implements IChatChannelMember {
  private long   accessorID;
  private String accessorName;
  private Date   untilWhen;
  private String reason;

  public long getAccessorID() {
    return accessorID;
  }

  public void setAccessorID(long accessorID) {
    this.accessorID = accessorID;
  }

  public String getAccessorName() {
    return accessorName;
  }

  public void setAccessorName(String accessorName) {
    this.accessorName = accessorName;
  }

  public Date getUntilWhen() {
    return untilWhen;
  }

  public void setUntilWhen(Date untilWhen) {
    this.untilWhen = untilWhen;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

}