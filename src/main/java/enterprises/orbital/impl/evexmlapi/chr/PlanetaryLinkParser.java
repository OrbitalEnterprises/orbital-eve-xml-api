package enterprises.orbital.impl.evexmlapi.chr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.chr.IPlanetaryLink;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiAuth;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class PlanetaryLinkParser extends AbstractApiParser<PlanetaryLinkResponse, Collection<IPlanetaryLink>> {
  protected Long planetID;

  public PlanetaryLinkParser(ApiConnector connector, Long planetID) {
    super(connector, PlanetaryLinkResponse.class, ApiEndpoint.CHR_PLANETARY_LINKS_V2);
    this.planetID = planetID;
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiPlanetaryLink.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addPlanetaryLink");
    return digester;
  }

  public PlanetaryLinkResponse getResponseWithPlanetID(ApiAuth auth) throws IOException {
    if (planetID != null)
      return getResponse(auth, "planetID", String.valueOf(planetID));
    else
      return getResponse(auth);
  }

  @Override
  public Collection<IPlanetaryLink> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    PlanetaryLinkResponse response = getResponseWithPlanetID(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IPlanetaryLink> result = new ArrayList<IPlanetaryLink>();
    result.addAll(response.getPlanetaryLinks());
    return result;
  }
}
