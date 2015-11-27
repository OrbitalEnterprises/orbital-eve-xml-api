package enterprises.orbital.impl.evexmlapi.crp;

import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractIndustryJobsParser;

public class IndustryJobsHistoryParser extends AbstractIndustryJobsParser {
  public IndustryJobsHistoryParser() {
    super(ApiEndpoint.CRP_INDUSTRY_JOBS_HISTORY_V2);
  }
}