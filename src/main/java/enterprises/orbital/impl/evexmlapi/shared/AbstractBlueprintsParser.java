package enterprises.orbital.impl.evexmlapi.shared;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.shared.IBlueprint;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public abstract class AbstractBlueprintsParser extends AbstractApiParser<BlueprintsResponse, Collection<IBlueprint>> {
  protected AbstractBlueprintsParser(ApiConnector connector, ApiEndpoint endpoint) {
    super(connector, BlueprintsResponse.class, endpoint);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiBlueprint.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row", "addBlueprint");
    return digester;
  }

  @Override
  public Collection<IBlueprint> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    BlueprintsResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IBlueprint> result = new ArrayList<IBlueprint>();
    result.addAll(response.getBlueprints());
    return result;
  }

}