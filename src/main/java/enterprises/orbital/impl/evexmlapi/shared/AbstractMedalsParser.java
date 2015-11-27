package enterprises.orbital.impl.evexmlapi.shared;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.shared.IMedal;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public abstract class AbstractMedalsParser<M extends Medal, T extends IMedal> extends AbstractApiParser<MedalsResponse, Collection<T>> {
  private final Class<M> medalClass;

  protected AbstractMedalsParser(ApiEndpoint endpoint, Class<M> medalClass) {
    super(MedalsResponse.class, endpoint);
    this.medalClass = medalClass;
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", medalClass);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addMedal");
    return digester;
  }

  @SuppressWarnings("unchecked")
  @Override
  public Collection<T> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    MedalsResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<T> result = new ArrayList<T>();
    for (Medal m : response.getMedals()) {
      result.add((T) m);
    }
    return result;
  }

}