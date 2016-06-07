package enterprises.orbital.impl.evexmlapi.chr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.digester.BeanPropertySetterRule;
import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.chr.INotificationText;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiAuth;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public class NotificationTextsParser extends AbstractApiParser<NotificationTextsResponse, Collection<INotificationText>> {
  private long[] notificationID;

  public NotificationTextsParser(ApiConnector connector, long... notificationID) {
    super(connector, NotificationTextsResponse.class, ApiEndpoint.CHR_NOTIFICATION_TEXTS_V2);
    this.notificationID = notificationID;
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();

    // Add missing IDs to a list
    digester.addBeanPropertySetter("eveapi/result/rowset/missingIDs", "missingID");

    // Otherwise, construct notification texts as we see them
    digester.addObjectCreate("eveapi/result/rowset/row", NotificationText.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addRule("eveapi/result/rowset/row", new MyBeanPropertySetterRule("notificationText"));

    // digester.addBeanPropertySetter("eveapi/result/rowset/row",
    // "notificationText");
    digester.addSetNext("eveapi/result/rowset/row", "addNotification");

    return digester;
  }

  private NotificationTextsResponse getResponseWithNotificationIDs(ApiAuth auth) throws IOException {
    if (notificationID.length > 0) {
      String ids = Arrays.toString(notificationID).replace(" ", "").replace("[", "").replace("]", "");
      return getResponse(auth, "IDs", ids);
    }
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
  public Collection<INotificationText> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    NotificationTextsResponse response = getResponseWithNotificationIDs(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<INotificationText> result = new ArrayList<INotificationText>();
    result.addAll(response.getNotificationTexts());
    for (long i : response.getMissingTexts()) {
      NotificationText missing = new NotificationText();
      missing.setNotificationID(i);
      missing.setMissing(true);
      result.add(missing);
    }
    return result;
  }
}
