package enterprises.orbital.impl.evexmlapi.crp;

import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractIndustryJobsParser;

public class IndustryJobsParser extends AbstractIndustryJobsParser {
  public IndustryJobsParser() {
    super(ApiEndpoint.CRP_INDUSTRY_JOBS_V2);
  }
}