package enterprises.orbital.impl.evexmlapi.chr;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import org.apache.commons.digester.BeanPropertySetterRule;
import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.chr.IMailBody;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiAuth;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class MailBodiesParser extends AbstractApiParser<MailBodiesResponse, Collection<IMailBody>> {
  protected long[] ids;

  public MailBodiesParser(ApiConnector connector, long... ids) {
    super(connector, MailBodiesResponse.class, ApiEndpoint.CHR_MAIL_BODIES_V2);
    this.ids = ids;
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiMailBody.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addRule("eveapi/result/rowset/row", new MyBeanPropertySetterRule("body"));
    digester.addSetNext("eveapi/result/rowset/row", "add");
    return digester;
  }

  public MailBodiesResponse getResponseWithIDs(ApiAuth auth) throws IOException {
    if (ids.length > 0) {
      return getResponse(auth, "ids", Arrays.toString(ids).replace(" ", "").replace("[", "").replace("]", ""));
    } else
      return getResponse(auth);
  }

  // Inner class to handle setting message content. We have to do this because
  // the usual BeanPropertySetter rule has this annoying feature that it trims
  // text when it sets a text property.
  private class MyBeanPropertySetterRule extends BeanPropertySetterRule {

    public MyBeanPropertySetterRule(String propertyName) {
      super(propertyName);
    }

    @Override
    public void body(String namespace, String name, String text) throws Exception {
      bodyText = text;
    }
  }

  @Override
  public Collection<IMailBody> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    MailBodiesResponse response = getResponseWithIDs(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IMailBody> result = new HashSet<IMailBody>();
    result.addAll(response.getMailBodies());
    return result;
  }
}
