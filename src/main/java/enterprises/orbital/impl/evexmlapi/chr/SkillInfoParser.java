package enterprises.orbital.impl.evexmlapi.chr;

import java.io.IOException;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.chr.ISkillInfo;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class SkillInfoParser extends AbstractApiParser<SkillInfoResponse, ISkillInfo> {
  public SkillInfoParser(ApiConnector connector) {
    super(connector, SkillInfoResponse.class, ApiEndpoint.CHR_SKILLS_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addBeanPropertySetter("eveapi/result/freeSkillPoints");

    CharacterSheetRowsetFactory rowsetHandler = new CharacterSheetRowsetFactory();

    digester.addFactoryCreate("eveapi/result/rowset", rowsetHandler);
    digester.addObjectCreate("eveapi/result/rowset/row", CharacterSheetRowsetData.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addData");
    digester.addSetNext("eveapi/result/rowset", "addCollector");

    return digester;
  }

  @Override
  public ISkillInfo retrieveResponse(
                                     AbstractAPIRequestAdapter adapter)
    throws IOException {
    SkillInfoResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    return response;
  }
}
