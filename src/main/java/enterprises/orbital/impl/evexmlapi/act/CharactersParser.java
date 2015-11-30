package enterprises.orbital.impl.evexmlapi.act;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.act.ICharacter;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class CharactersParser extends AbstractApiParser<CharactersResponse, Collection<ICharacter>> {
  public CharactersParser(ApiConnector connector) {
    super(connector, CharactersResponse.class, ApiEndpoint.ACT_CHARACTERS_V1);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiCharacter.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addEveCharacter");
    return digester;
  }

  @Override
  public Collection<ICharacter> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    CharactersResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<ICharacter> result = new ArrayList<ICharacter>();
    result.addAll(response.getEveCharacters());
    return result;
  }
}