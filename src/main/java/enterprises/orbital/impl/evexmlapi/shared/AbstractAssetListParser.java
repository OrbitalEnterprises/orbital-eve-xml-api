package enterprises.orbital.impl.evexmlapi.shared;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.shared.IAsset;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public abstract class AbstractAssetListParser extends AbstractApiParser<AssetListResponse, Collection<IAsset>> {
  protected AbstractAssetListParser(ApiConnector connector, ApiEndpoint endpoint) {
    super(connector, AssetListResponse.class, endpoint);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("*/rowset/row", ApiAsset.class);
    digester.addSetProperties("*/rowset/row");
    digester.addSetNext("*/rowset/row", "addAsset");
    return digester;
  }

  @Override
  public Collection<IAsset> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    AssetListResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IAsset> result = new HashSet<IAsset>();
    result.addAll(response.getAssets());
    return result;
  }

}