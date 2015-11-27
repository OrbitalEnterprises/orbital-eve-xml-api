package enterprises.orbital.impl.evexmlapi.chr;

import java.util.ArrayList;
import java.util.List;

import enterprises.orbital.evexmlapi.chr.IChatChannel;
import enterprises.orbital.evexmlapi.chr.IChatChannelMember;

public class ApiChatChannel implements IChatChannel {
  private long                             channelID;
  private long                             ownerID;
  private String                           ownerName;
  private String                           displayName;
  private String                           comparisonKey;
  private boolean                          hasPassword;
  private String                           motd;
  private final List<ApiChatChannelMember> allowed   = new ArrayList<ApiChatChannelMember>();
  private final List<ApiChatChannelMember> blocked   = new ArrayList<ApiChatChannelMember>();
  private final List<ApiChatChannelMember> muted     = new ArrayList<ApiChatChannelMember>();
  private final List<ApiChatChannelMember> operators = new ArrayList<ApiChatChannelMember>();

  @Override
  public long getChannelID() {
    return channelID;
  }

  public void setChannelID(long channelID) {
    this.channelID = channelID;
  }

  @Override
  public long getOwnerID() {
    return ownerID;
  }

  public void setOwnerID(long ownerID) {
    this.ownerID = ownerID;
  }

  @Override
  public String getOwnerName() {
    return ownerName;
  }

  public void setOwnerName(String ownerName) {
    this.ownerName = ownerName;
  }

  @Override
  public String getDisplayName() {
    return displayName;
  }

  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }

  @Override
  public String getComparisonKey() {
    return comparisonKey;
  }

  public void setComparisonKey(String comparisonKey) {
    this.comparisonKey = comparisonKey;
  }

  @Override
  public boolean hasPassword() {
    return hasPassword;
  }

  public void setHasPassword(boolean hasPassword) {
    this.hasPassword = hasPassword;
  }

  @Override
  public String getMOTD() {
    return motd;
  }

  public void setMotd(String motd) {
    this.motd = motd;
  }

  @Override
  public List<IChatChannelMember> getAllowed() {
    List<IChatChannelMember> result = new ArrayList<IChatChannelMember>();
    result.addAll(allowed);
    return result;
  }

  @Override
  public List<IChatChannelMember> getBlocked() {
    List<IChatChannelMember> result = new ArrayList<IChatChannelMember>();
    result.addAll(blocked);
    return result;
  }

  @Override
  public List<IChatChannelMember> getMuted() {
    List<IChatChannelMember> result = new ArrayList<IChatChannelMember>();
    result.addAll(muted);
    return result;
  }

  @Override
  public List<IChatChannelMember> getOperators() {
    List<IChatChannelMember> result = new ArrayList<IChatChannelMember>();
    result.addAll(operators);
    return result;
  }

  public void addMemberCollector(ChatChannelsParser.MemberCollector col) {
    switch (col.getName()) {
    case "allowed":
      allowed.addAll(col.getMembers());
      break;

    case "blocked":
      blocked.addAll(col.getMembers());
      break;

    case "muted":
      muted.addAll(col.getMembers());
      break;

    case "operators":
      operators.addAll(col.getMembers());
      break;

    default:
      assert false;
    }
  }

}