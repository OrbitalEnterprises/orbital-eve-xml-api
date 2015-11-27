package enterprises.orbital.impl.evexmlapi.eve;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.eve.ICharacterLookup;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class CharacterLookupParser extends AbstractApiParser<CharacterLookupResponse, Collection<ICharacterLookup>> {
  private String[] names;
  private long[]   ids;

  public CharacterLookupParser(String... names) {
    super(CharacterLookupResponse.class, ApiEndpoint.EVE_CHARACTER_ID_V2);
    this.names = names;
  }

  public CharacterLookupParser(long... ids) {
    super(CharacterLookupResponse.class, ApiEndpoint.EVE_CHARACTER_NAME_V2);
    this.ids = ids;
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiCharacterLookup.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addCharacterLookup");
    return digester;
  }

  public CharacterLookupResponse getResponseWithParams() throws IOException {
    if (names != null)
      return getResponse("names", Arrays.toString(names).replace(" ", "").replace("[", "").replace("]", ""));
    else
      return getResponse("ids", Arrays.toString(ids).replace(" ", "").replace("[", "").replace("]", ""));
  }

  @Override
  public Collection<ICharacterLookup> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    CharacterLookupResponse response = getResponseWithParams();
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<ICharacterLookup> result = new HashSet<ICharacterLookup>();
    result.addAll(response.getCharacterLookups());
    return result;
  }
}