package enterprises.orbital.impl.evexmlapi.chr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.chr.IPlanetaryRoute;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiAuth;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class PlanetaryRouteParser extends AbstractApiParser<PlanetaryRouteResponse, Collection<IPlanetaryRoute>> {
  private Long planetID;

  public PlanetaryRouteParser(ApiConnector connector, Long planetID) {
    super(connector, PlanetaryRouteResponse.class, ApiEndpoint.CHR_PLANETARY_ROUTES_V2);
    this.planetID = planetID;
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiPlanetaryRoute.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addPlanetaryRoute");
    return digester;
  }

  private PlanetaryRouteResponse getResponseWithPlanetID(ApiAuth auth) throws IOException {
    if (planetID != null)
      return getResponse(auth, "planetID", String.valueOf(planetID));
    else
      return getResponse(auth);
  }

  @Override
  public Collection<IPlanetaryRoute> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    PlanetaryRouteResponse response = getResponseWithPlanetID(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IPlanetaryRoute> result = new ArrayList<IPlanetaryRoute>();
    result.addAll(response.getPlanetaryRoutes());
    return result;
  }
}
