package enterprises.orbital.impl.evexmlapi.crp;

import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractLocationsParser;

public class LocationsParser extends AbstractLocationsParser {
  public LocationsParser(ApiConnector connector, long... itemID) {
    super(connector, ApiEndpoint.CRP_LOCATIONS_V2, itemID);
  }

}