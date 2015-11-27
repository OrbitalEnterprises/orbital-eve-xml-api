package enterprises.orbital.evexmlapi.chr;

import java.util.Date;

public interface IChatChannelMember {
  public long getAccessorID();

  public String getAccessorName();

  public Date getUntilWhen();

  public String getReason();
}
