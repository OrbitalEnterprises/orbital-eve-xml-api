package enterprises.orbital.impl.evexmlapi.eve;

import java.util.Collection;
import java.util.HashSet;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class CharacterLookupResponse extends ApiResponse {
  private final Collection<ApiCharacterLookup> characters = new HashSet<ApiCharacterLookup>();

  public Collection<ApiCharacterLookup> getCharacterLookups() {
    return characters;
  }

  public void addCharacterLookup(ApiCharacterLookup lookup) {
    characters.add(lookup);
  }
}