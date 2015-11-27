package enterprises.orbital.impl.evexmlapi.shared;

import java.util.ArrayList;
import java.util.Collection;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class IndustryJobsResponse extends ApiResponse {
  private static final long                serialVersionUID = 1693706732400160880L;
  private final Collection<ApiIndustryJob> industryJobs     = new ArrayList<ApiIndustryJob>();

  public void addIndustryJob(ApiIndustryJob industryJob) {
    industryJobs.add(industryJob);
  }

  public Collection<ApiIndustryJob> getIndustryJobs() {
    return industryJobs;
  }
}