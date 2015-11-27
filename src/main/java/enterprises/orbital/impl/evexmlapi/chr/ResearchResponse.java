package enterprises.orbital.impl.evexmlapi.chr;

import java.util.ArrayList;
import java.util.List;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class ResearchResponse extends ApiResponse {
  private static final long            serialVersionUID = 464887966101313399L;
  private final List<ApiResearchAgent> researchAgents   = new ArrayList<ApiResearchAgent>();

  public void addResearchAgent(ApiResearchAgent researchAgent) {
    researchAgents.add(researchAgent);
  }

  public List<ApiResearchAgent> getResearchAgents() {
    return researchAgents;
  }
}