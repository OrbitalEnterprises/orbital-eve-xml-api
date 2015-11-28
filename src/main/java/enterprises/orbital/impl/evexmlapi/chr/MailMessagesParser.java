package enterprises.orbital.impl.evexmlapi.chr;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.chr.IMailMessage;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class MailMessagesParser extends AbstractApiParser<MailMessagesResponse, Collection<IMailMessage>> {
  public MailMessagesParser(ApiConnector connector) {
    super(connector, MailMessagesResponse.class, ApiEndpoint.CHR_MAIL_MESSAGES_V2);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiMailMessage.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addApiMail");
    return digester;
  }

  @Override
  public Collection<IMailMessage> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    MailMessagesResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IMailMessage> result = new HashSet<IMailMessage>();
    result.addAll(response.getApiMails());
    return result;
  }
}