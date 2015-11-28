package enterprises.orbital.impl.evexmlapi.shared;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.shared.IIndustryJob;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public abstract class AbstractIndustryJobsParser extends AbstractApiParser<IndustryJobsResponse, Collection<IIndustryJob>> {
  protected AbstractIndustryJobsParser(ApiConnector connector, ApiEndpoint endpoint) {
    super(connector, IndustryJobsResponse.class, endpoint);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiIndustryJob.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addIndustryJob");
    return digester;
  }

  @Override
  public Collection<IIndustryJob> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    IndustryJobsResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IIndustryJob> result = new ArrayList<IIndustryJob>();
    result.addAll(response.getIndustryJobs());
    return result;
  }

}