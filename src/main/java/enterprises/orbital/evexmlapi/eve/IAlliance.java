package enterprises.orbital.evexmlapi.eve;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IAlliance.class)
public interface IAlliance {
  public long getAllianceID();

  public long getExecutorCorpID();

  public Collection<IMemberCorporation> getMemberCorporations();

  public int getMemberCount();

  public String getName();

  public String getShortName();

  public Date getStartDate();
}
