package enterprises.orbital.impl.evexmlapi.eve;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.eve.ICharacterAffiliation;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class CharacterAffiliationParser extends AbstractApiParser<CharacterAffiliationResponse, Collection<ICharacterAffiliation>> {
  private long[] ids;

  public CharacterAffiliationParser(ApiConnector connector, long... ids) {
    super(connector, CharacterAffiliationResponse.class, ApiEndpoint.EVE_CHARACTER_AFFILIATION_V2);
    this.ids = ids;
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiCharacterAffiliation.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addCharacterAffiliation");
    return digester;
  }

  public CharacterAffiliationResponse getResponseWithParams() throws IOException {
    return getResponse("ids", Arrays.toString(ids).replace(" ", "").replace("[", "").replace("]", ""));
  }

  @Override
  public Collection<ICharacterAffiliation> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    CharacterAffiliationResponse response = getResponseWithParams();
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    return response.getCharacterAffiliations();
  }
}