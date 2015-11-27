package enterprises.orbital.impl.evexmlapi.chr;

import java.io.IOException;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.chr.ICharacterSheet;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class CharacterSheetParser extends AbstractApiParser<CharacterSheetResponse, ICharacterSheet> {
  public CharacterSheetParser() {
    super(CharacterSheetResponse.class, ApiEndpoint.CHR_CHARACTER_SHEET_V1);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addBeanPropertySetter("eveapi/result/characterID");
    digester.addBeanPropertySetter("eveapi/result/name");
    digester.addBeanPropertySetter("eveapi/result/homeStationID");
    digester.addBeanPropertySetter("eveapi/result/DoB", "dateOfBirth");
    digester.addBeanPropertySetter("eveapi/result/race");
    digester.addBeanPropertySetter("eveapi/result/bloodLine");
    digester.addBeanPropertySetter("eveapi/result/ancestry");
    digester.addBeanPropertySetter("eveapi/result/gender");
    digester.addBeanPropertySetter("eveapi/result/corporationName");
    digester.addBeanPropertySetter("eveapi/result/corporationID");
    digester.addBeanPropertySetter("eveapi/result/allianceName");
    digester.addBeanPropertySetter("eveapi/result/allianceID");
    digester.addBeanPropertySetter("eveapi/result/factionName");
    digester.addBeanPropertySetter("eveapi/result/factionID");
    digester.addBeanPropertySetter("eveapi/result/cloneTypeID");
    digester.addBeanPropertySetter("eveapi/result/cloneName");
    digester.addBeanPropertySetter("eveapi/result/cloneSkillPoints");
    digester.addBeanPropertySetter("eveapi/result/freeSkillPoints");
    digester.addBeanPropertySetter("eveapi/result/freeRespecs");
    digester.addBeanPropertySetter("eveapi/result/cloneJumpDate");
    digester.addBeanPropertySetter("eveapi/result/lastRespecDate");
    digester.addBeanPropertySetter("eveapi/result/lastTimedRespec");
    digester.addBeanPropertySetter("eveapi/result/remoteStationDate");
    digester.addBeanPropertySetter("eveapi/result/jumpActivation");
    digester.addBeanPropertySetter("eveapi/result/jumpFatigue");
    digester.addBeanPropertySetter("eveapi/result/jumpLastUpdate");
    digester.addBeanPropertySetter("eveapi/result/balance");
    digester.addBeanPropertySetter("eveapi/result/attributes/intelligence");
    digester.addBeanPropertySetter("eveapi/result/attributes/memory");
    digester.addBeanPropertySetter("eveapi/result/attributes/charisma");
    digester.addBeanPropertySetter("eveapi/result/attributes/perception");
    digester.addBeanPropertySetter("eveapi/result/attributes/willpower");

    CharacterSheetRowsetFactory rowsetHandler = new CharacterSheetRowsetFactory();

    digester.addFactoryCreate("eveapi/result/rowset", rowsetHandler);
    digester.addObjectCreate("eveapi/result/rowset/row", CharacterSheetRowsetData.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addData");
    digester.addSetNext("eveapi/result/rowset", "addCollector");

    return digester;
  }

  @Override
  public ICharacterSheet retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    CharacterSheetResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    return response;
  }
}
