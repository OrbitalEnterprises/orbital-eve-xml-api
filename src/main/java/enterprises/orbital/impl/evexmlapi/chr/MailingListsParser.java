package enterprises.orbital.impl.evexmlapi.chr;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.chr.IMailList;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class MailingListsParser extends AbstractApiParser<MailingListsResponse, Collection<IMailList>> {
  public MailingListsParser(ApiConnector connector) {
    super(connector, MailingListsResponse.class, ApiEndpoint.CHR_MAILING_LISTS_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiMailingList.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addMailingList");
    return digester;
  }

  @Override
  public Collection<IMailList> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    MailingListsResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IMailList> result = new HashSet<IMailList>();
    result.addAll(response.getMailingLists());
    return result;
  }

}