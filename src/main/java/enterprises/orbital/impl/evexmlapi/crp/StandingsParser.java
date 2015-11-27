package enterprises.orbital.impl.evexmlapi.crp;

import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractStandingsParser;

public class StandingsParser extends AbstractStandingsParser {
  public StandingsParser() {
    super(ApiEndpoint.CRP_STANDINGS_V2, "corporationNPCStandings");
  }
}