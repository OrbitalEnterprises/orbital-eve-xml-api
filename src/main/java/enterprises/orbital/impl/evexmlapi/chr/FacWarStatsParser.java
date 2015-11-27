package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractFacWarStatsParser;

public class FacWarStatsParser extends AbstractFacWarStatsParser {
  public FacWarStatsParser() {
    super(ApiEndpoint.CHR_FAC_WAR_STATS_V2);
  }

}