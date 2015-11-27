package enterprises.orbital.impl.evexmlapi.shared;

import java.io.IOException;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.shared.IFacWarStats;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public abstract class AbstractFacWarStatsParser extends AbstractApiParser<FacWarStatsResponse, IFacWarStats> {
  protected AbstractFacWarStatsParser(ApiEndpoint endpoint) {
    super(FacWarStatsResponse.class, endpoint);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addBeanPropertySetter("eveapi/result/factionID");
    digester.addBeanPropertySetter("eveapi/result/factionName");
    digester.addBeanPropertySetter("eveapi/result/enlisted");
    digester.addBeanPropertySetter("eveapi/result/currentRank");
    digester.addBeanPropertySetter("eveapi/result/highestRank");
    digester.addBeanPropertySetter("eveapi/result/killsYesterday");
    digester.addBeanPropertySetter("eveapi/result/killsLastWeek");
    digester.addBeanPropertySetter("eveapi/result/killsTotal");
    digester.addBeanPropertySetter("eveapi/result/victoryPointsYesterday");
    digester.addBeanPropertySetter("eveapi/result/victoryPointsLastWeek");
    digester.addBeanPropertySetter("eveapi/result/victoryPointsTotal");
    digester.addBeanPropertySetter("eveapi/result/pilots");
    return digester;
  }

  @Override
  public IFacWarStats retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    FacWarStatsResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    return response;
  }

}