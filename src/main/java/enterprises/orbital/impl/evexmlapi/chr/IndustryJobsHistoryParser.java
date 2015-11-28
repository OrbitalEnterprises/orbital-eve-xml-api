package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractIndustryJobsParser;

public class IndustryJobsHistoryParser extends AbstractIndustryJobsParser {
  public IndustryJobsHistoryParser(ApiConnector connector) {
    super(connector, ApiEndpoint.CHR_INDUSTRY_JOBS_HISTORY_V2);
  }
}