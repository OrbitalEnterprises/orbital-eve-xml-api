package enterprises.orbital.evexmlapi.chr;

import java.util.Collection;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IChatChannel.class)
public interface IChatChannel {
  public long getChannelID();

  public long getOwnerID();

  public String getOwnerName();

  public String getDisplayName();

  public String getComparisonKey();

  public boolean hasPassword();

  public String getMOTD();

  public Collection<IChatChannelMember> getAllowed();

  public Collection<IChatChannelMember> getBlocked();

  public Collection<IChatChannelMember> getMuted();

  public Collection<IChatChannelMember> getOperators();
}
