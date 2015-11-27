package enterprises.orbital.impl.evexmlapi.chr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.chr.IPlanetaryColony;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class PlanetaryColonyParser extends AbstractApiParser<PlanetaryColonyResponse, Collection<IPlanetaryColony>> {
  public PlanetaryColonyParser() {
    super(PlanetaryColonyResponse.class, ApiEndpoint.CHR_PLANETARY_COLONIES_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiPlanetaryColony.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addPlanetaryColony");
    return digester;
  }

  @Override
  public Collection<IPlanetaryColony> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    PlanetaryColonyResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IPlanetaryColony> result = new ArrayList<IPlanetaryColony>();
    result.addAll(response.getPlanetaryColonies());
    return result;
  }

}
