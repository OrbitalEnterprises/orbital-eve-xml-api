package enterprises.orbital.impl.evexmlapi.eve;

import java.io.IOException;

import org.apache.commons.digester.AbstractObjectCreationFactory;
import org.apache.commons.digester.Digester;
import org.xml.sax.Attributes;

import enterprises.orbital.evexmlapi.eve.IFacWarSummary;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class EveFacWarStatsParser extends AbstractApiParser<EveFacWarStatsResponse, IFacWarSummary> {
  public EveFacWarStatsParser(ApiConnector connector) {
    super(connector, EveFacWarStatsResponse.class, ApiEndpoint.EVE_FAC_WAR_STATS_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addBeanPropertySetter("eveapi/result/totals/killsYesterday");
    digester.addBeanPropertySetter("eveapi/result/totals/killsLastWeek");
    digester.addBeanPropertySetter("eveapi/result/totals/killsTotal");
    digester.addBeanPropertySetter("eveapi/result/totals/victoryPointsYesterday");
    digester.addBeanPropertySetter("eveapi/result/totals/victoryPointsLastWeek");
    digester.addBeanPropertySetter("eveapi/result/totals/victoryPointsTotal");

    digester.addFactoryCreate("eveapi/result/rowset/row", new AbstractObjectCreationFactory() {
      @Override
      public Object createObject(Attributes attributes) throws Exception {
        if (attributes.getValue("pilots") != null) return new ApiFactionStats();
        return new ApiFactionWar();
      }
    });
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addStat");

    return digester;
  }

  @Override
  public IFacWarSummary retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    EveFacWarStatsResponse response = getResponse();
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    return response;
  }

}