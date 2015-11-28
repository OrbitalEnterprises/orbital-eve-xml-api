package enterprises.orbital.impl.evexmlapi.crp;

import java.io.IOException;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;

import enterprises.orbital.evexmlapi.crp.ICorporationSheet;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiAuth;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class CorporationSheetParser extends AbstractApiParser<CorporationSheetResponse, ICorporationSheet> {
  protected Long corporationID;

  public CorporationSheetParser(ApiConnector connector, Long corporationID) {
    super(connector, CorporationSheetResponse.class, ApiEndpoint.CRP_CORPORATION_SHEET_V2);
    this.corporationID = corporationID;
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addBeanPropertySetter("eveapi/result/corporationID");
    digester.addBeanPropertySetter("eveapi/result/corporationName");
    digester.addBeanPropertySetter("eveapi/result/ticker");
    digester.addBeanPropertySetter("eveapi/result/ceoID");
    digester.addBeanPropertySetter("eveapi/result/ceoName");
    digester.addBeanPropertySetter("eveapi/result/stationID");
    digester.addBeanPropertySetter("eveapi/result/stationName");
    digester.addBeanPropertySetter("eveapi/result/description");
    digester.addBeanPropertySetter("eveapi/result/url");
    digester.addBeanPropertySetter("eveapi/result/allianceID");
    digester.addBeanPropertySetter("eveapi/result/allianceName");
    digester.addBeanPropertySetter("eveapi/result/taxRate");
    digester.addBeanPropertySetter("eveapi/result/memberCount");
    digester.addBeanPropertySetter("eveapi/result/memberLimit");
    digester.addBeanPropertySetter("eveapi/result/shares");
    digester.addObjectCreate("eveapi/result/logo", ApiCorpLogo.class);
    digester.addBeanPropertySetter("eveapi/result/logo/graphicsID");
    digester.addBeanPropertySetter("eveapi/result/logo/shape1");
    digester.addBeanPropertySetter("eveapi/result/logo/shape2");
    digester.addBeanPropertySetter("eveapi/result/logo/shape3");
    digester.addBeanPropertySetter("eveapi/result/logo/color1");
    digester.addBeanPropertySetter("eveapi/result/logo/color2");
    digester.addBeanPropertySetter("eveapi/result/logo/color3");
    digester.addSetNext("eveapi/result/logo", "setLogo");
    digester.addFactoryCreate("eveapi/result/rowset", new AbstractObjectCreationFactory() {
      @Override
      public Object createObject(Attributes attributes) throws Exception {
        String name = attributes.getValue("name");
        if (name != null) {
          DivisionList divisionList = new DivisionList();
          divisionList.setName(name);
          return divisionList;
        }
        return null;
      }
    });
    digester.addObjectCreate("eveapi/result/rowset/row", Division.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addDivision");
    digester.addSetNext("eveapi/result/rowset", "addDivisionList");
    return digester;
  }

  public CorporationSheetResponse getResponseWithCorpID(ApiAuth auth) throws IOException {
    if (corporationID != null)
      // If corporation ID is specified, then this will ignore auth info and retrieve public info only.
      // So no reason to base auth here.
      return getResponse("corporationID", Long.toString(corporationID));
    else
      return getResponse(auth);
  }

  @Override
  public ICorporationSheet retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    CorporationSheetResponse response = getResponseWithCorpID(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    return response;
  }
}