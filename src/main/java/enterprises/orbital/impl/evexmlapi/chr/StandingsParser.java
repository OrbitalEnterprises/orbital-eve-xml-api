package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractStandingsParser;

public class StandingsParser extends AbstractStandingsParser {
  public StandingsParser(ApiConnector connector) {
    super(connector, ApiEndpoint.CHR_STANDINGS_V2, "characterNPCStandings");
  }
}