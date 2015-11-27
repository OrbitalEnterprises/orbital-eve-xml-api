package enterprises.orbital.impl.evexmlapi.act;

import java.util.ArrayList;
import java.util.Collection;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class CharactersResponse extends ApiResponse {
	private static final long serialVersionUID = 1L;
	private final Collection<ApiCharacter> eveCharacters = new ArrayList<ApiCharacter>();

	public void addEveCharacter(ApiCharacter eveCharacter) {
		eveCharacters.add(eveCharacter);
	}

	public Collection<ApiCharacter> getEveCharacters() {
		return eveCharacters;
	}
}