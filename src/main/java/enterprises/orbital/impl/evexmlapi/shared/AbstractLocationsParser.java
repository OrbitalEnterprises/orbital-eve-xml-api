package enterprises.orbital.impl.evexmlapi.shared;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.shared.ILocation;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiAuth;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public abstract class AbstractLocationsParser extends AbstractApiParser<LocationsResponse, Collection<ILocation>> {
  protected long[] itemID;

  protected AbstractLocationsParser(ApiConnector connector, ApiEndpoint endpoint, long[] itemID) {
    super(connector, LocationsResponse.class, endpoint);
    this.itemID = itemID;
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiLocation.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addLocation");
    return digester;
  }

  protected LocationsResponse getResponseWithItemIDs(ApiAuth auth) throws IOException {
    Map<String, String> extraParams = new HashMap<String, String>();
    extraParams.put("IDs", Arrays.toString(itemID).replace(" ", "").replace("[", "").replace("]", ""));
    return getResponse(auth, extraParams);
  }

  @Override
  public Collection<ILocation> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    LocationsResponse response = getResponseWithItemIDs(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    return response.getLocations();
  }

}