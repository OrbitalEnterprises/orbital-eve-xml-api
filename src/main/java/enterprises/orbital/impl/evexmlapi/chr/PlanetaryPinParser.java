package enterprises.orbital.impl.evexmlapi.chr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.chr.IPlanetaryPin;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiAuth;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class PlanetaryPinParser extends AbstractApiParser<PlanetaryPinResponse, Collection<IPlanetaryPin>> {
  protected Long planetID;

  public PlanetaryPinParser(ApiConnector connector, Long planetID) {
    super(connector, PlanetaryPinResponse.class, ApiEndpoint.CHR_PLANETARY_PINS_V2);
    this.planetID = planetID;
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiPlanetaryPin.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addPlanetaryPin");
    return digester;
  }

  public PlanetaryPinResponse getResponseWithPlanetID(ApiAuth auth) throws IOException {
    if (planetID != null)
      return getResponse(auth, "planetID", String.valueOf(planetID));
    else
      return getResponse(auth);
  }

  @Override
  public Collection<IPlanetaryPin> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    PlanetaryPinResponse response = getResponseWithPlanetID(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IPlanetaryPin> result = new ArrayList<IPlanetaryPin>();
    result.addAll(response.getPlanetaryPins());
    return result;
  }
}
