package enterprises.orbital.impl.evexmlapi.chr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.chr.IResearchAgent;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

// Replace the default implementation with the proper API version (2)
public class ResearchParser extends AbstractApiParser<ResearchResponse, Collection<IResearchAgent>> {
  public ResearchParser() {
    super(ResearchResponse.class, ApiEndpoint.CHR_RESEARCH_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiResearchAgent.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addResearchAgent");
    return digester;
  }

  @Override
  public Collection<IResearchAgent> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    ResearchResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IResearchAgent> result = new ArrayList<IResearchAgent>();
    result.addAll(response.getResearchAgents());
    return result;
  }

}
