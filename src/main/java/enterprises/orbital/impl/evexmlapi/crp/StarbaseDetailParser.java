package enterprises.orbital.impl.evexmlapi.crp;

import java.io.IOException;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.crp.IStarbaseDetail;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiAuth;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class StarbaseDetailParser extends AbstractApiParser<StarbaseDetailResponse, IStarbaseDetail> {
  Long itemID;

  public StarbaseDetailParser(ApiConnector connector, Long itemID) {
    super(connector, StarbaseDetailResponse.class, ApiEndpoint.CRP_STARBASE_DETAIL_V2);
    this.itemID = itemID;
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addBeanPropertySetter("eveapi/result/state");
    digester.addBeanPropertySetter("eveapi/result/stateTimestamp");
    digester.addBeanPropertySetter("eveapi/result/onlineTimestamp");
    digester.addBeanPropertySetter("eveapi/result/generalSettings/usageFlags");
    digester.addBeanPropertySetter("eveapi/result/generalSettings/deployFlags");
    digester.addBeanPropertySetter("eveapi/result/generalSettings/allowCorporationMembers");
    digester.addBeanPropertySetter("eveapi/result/generalSettings/allowAllianceMembers");

    digester.addSetProperties("eveapi/result/combatSettings/useStandingsFrom", "ownerID", "useStandingsFrom");

    digester.addObjectCreate("eveapi/result/combatSettings/onStandingDrop", ApiCombatSetting.class);
    digester.addSetProperties("eveapi/result/combatSettings/onStandingDrop");
    digester.addSetNext("eveapi/result/combatSettings/onStandingDrop", "setOnStandingDrop");

    digester.addObjectCreate("eveapi/result/combatSettings/onStatusDrop", ApiCombatSetting.class);
    digester.addSetProperties("eveapi/result/combatSettings/onStatusDrop");
    digester.addSetNext("eveapi/result/combatSettings/onStatusDrop", "setOnStatusDrop");

    digester.addObjectCreate("eveapi/result/combatSettings/onAggression", ApiCombatSetting.class);
    digester.addSetProperties("eveapi/result/combatSettings/onAggression");
    digester.addSetNext("eveapi/result/combatSettings/onAggression", "setOnAggression");

    digester.addObjectCreate("eveapi/result/combatSettings/onCorporationWar", ApiCombatSetting.class);
    digester.addSetProperties("eveapi/result/combatSettings/onCorporationWar");
    digester.addSetNext("eveapi/result/combatSettings/onCorporationWar", "setOnCorporationWar");

    digester.addObjectCreate("eveapi/result/rowset/row", FuelLevel.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addFuelLevel");
    return digester;
  }

  public StarbaseDetailResponse getResponseWithItemID(ApiAuth auth) throws IOException {
    if (itemID != null)
      return getResponse(auth, "itemID", Long.toString(itemID));
    else
      return getResponse(auth);
  }

  @Override
  public IStarbaseDetail retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    StarbaseDetailResponse response = getResponseWithItemID(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    return response;
  }
}
