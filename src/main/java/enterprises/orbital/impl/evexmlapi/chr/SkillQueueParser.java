package enterprises.orbital.impl.evexmlapi.chr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.chr.ISkillInQueue;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class SkillQueueParser extends AbstractApiParser<SkillQueueResponse, Collection<ISkillInQueue>> {
  public SkillQueueParser(ApiConnector connector) {
    super(connector, SkillQueueResponse.class, ApiEndpoint.CHR_SKILL_QUEUE_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiSkillQueueItem.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addSkillQueueItem");
    return digester;
  }

  @Override
  public Collection<ISkillInQueue> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    SkillQueueResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<ISkillInQueue> result = new ArrayList<ISkillInQueue>();
    result.addAll(response.getSkillQueueItems());
    return result;
  }

}