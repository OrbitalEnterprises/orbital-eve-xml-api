package enterprises.orbital.impl.evexmlapi.crp;

import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractStandingsParser;

public class StandingsParser extends AbstractStandingsParser {
  public StandingsParser(ApiConnector connector) {
    super(connector, ApiEndpoint.CRP_STANDINGS_V2, "corporationNPCStandings");
  }
}