package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractIndustryJobsParser;

public class IndustryJobsParser extends AbstractIndustryJobsParser {
  public IndustryJobsParser(ApiConnector connector) {
    super(connector, ApiEndpoint.CHR_INDUSTRY_JOBS_V2);
  }

}