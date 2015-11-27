package enterprises.orbital.impl.evexmlapi.eve;

import java.io.IOException;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;

import enterprises.orbital.evexmlapi.eve.ICharacterInfo;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiAuth;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class CharacterInfoParser extends AbstractApiParser<CharacterInfoResponse, ICharacterInfo> {
  protected Long characterID;

  public CharacterInfoParser(Long characterID) {
    super(CharacterInfoResponse.class, ApiEndpoint.EVE_CHARACTER_INFO_V2);
    this.characterID = characterID;
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addBeanPropertySetter("eveapi/result/characterID");
    digester.addBeanPropertySetter("eveapi/result/characterName");
    digester.addBeanPropertySetter("eveapi/result/race");
    digester.addBeanPropertySetter("eveapi/result/bloodline");
    digester.addBeanPropertySetter("eveapi/result/accountBalance");
    digester.addBeanPropertySetter("eveapi/result/skillPoints");
    digester.addBeanPropertySetter("eveapi/result/shipName");
    digester.addBeanPropertySetter("eveapi/result/shipTypeID");
    digester.addBeanPropertySetter("eveapi/result/shipTypeName");
    digester.addBeanPropertySetter("eveapi/result/corporationID");
    digester.addBeanPropertySetter("eveapi/result/corporation");
    digester.addBeanPropertySetter("eveapi/result/corporationDate");
    digester.addBeanPropertySetter("eveapi/result/allianceID");
    digester.addBeanPropertySetter("eveapi/result/alliance");
    digester.addBeanPropertySetter("eveapi/result/allianceDate");
    digester.addBeanPropertySetter("eveapi/result/lastKnownLocation");
    digester.addBeanPropertySetter("eveapi/result/securityStatus");

    digester.addFactoryCreate("eveapi/result/rowset/row", new AbstractObjectCreationFactory() {
      @Override
      public Object createObject(Attributes attributes) throws Exception {
        return new ApiEmploymentHistory();
      }
    });
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addEmploymentHistory");

    return digester;
  }

  public CharacterInfoResponse getResponseWithCharacterID(ApiAuth auth) throws IOException {
    if (characterID != null)
      return getResponse("characterID", Long.toString(characterID));
    else
      return getResponse(auth);
  }

  @Override
  public ICharacterInfo retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    CharacterInfoResponse response = getResponseWithCharacterID(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    return response;
  }
}