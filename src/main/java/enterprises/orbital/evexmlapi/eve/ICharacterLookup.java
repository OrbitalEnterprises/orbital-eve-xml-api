package enterprises.orbital.evexmlapi.eve;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = ICharacterLookup.class)
public interface ICharacterLookup {
  public long getCharacterID();

  public String getName();
}
