package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractIndustryJobsParser;

public class IndustryJobsHistoryParser extends AbstractIndustryJobsParser {
  public IndustryJobsHistoryParser() {
    super(ApiEndpoint.CHR_INDUSTRY_JOBS_HISTORY_V2);
  }
}