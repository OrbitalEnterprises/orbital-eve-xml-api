package enterprises.orbital.evexmlapi.chr;

import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IChatChannelMember.class)
public interface IChatChannelMember {
  public long getAccessorID();

  public String getAccessorName();

  public Date getUntilWhen();

  public String getReason();
}
