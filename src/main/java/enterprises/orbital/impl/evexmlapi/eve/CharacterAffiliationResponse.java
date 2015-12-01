package enterprises.orbital.impl.evexmlapi.eve;

import java.util.Collection;
import java.util.HashSet;

import enterprises.orbital.evexmlapi.eve.ICharacterAffiliation;
import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class CharacterAffiliationResponse extends ApiResponse {
  private final Collection<ICharacterAffiliation> characters = new HashSet<ICharacterAffiliation>();

  public Collection<ICharacterAffiliation> getCharacterAffiliations() {
    return characters;
  }

  public void addCharacterAffiliation(ApiCharacterAffiliation lookup) {
    characters.add(lookup);
  }
}