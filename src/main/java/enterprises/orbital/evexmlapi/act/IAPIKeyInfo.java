package enterprises.orbital.evexmlapi.act;

import java.util.Collection;
import java.util.Date;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IAPIKeyInfo.class)
public interface IAPIKeyInfo {
  public long getAccessMask();

  public String getType();

  public Date getExpires();

  public Collection<ICharacter> getCharacters();
}
