package enterprises.orbital.impl.evexmlapi.shared;

import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.shared.IAsset;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiAuth;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public abstract class AbstractAssetListParser extends AbstractApiParser<AssetListResponse, Collection<IAsset>> {

  protected boolean flat = false;

  protected AbstractAssetListParser(ApiConnector connector, ApiEndpoint endpoint, boolean flat) {
    super(connector, AssetListResponse.class, endpoint);
    this.flat = flat;
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("*/rowset/row", ApiAsset.class);
    digester.addSetProperties("*/rowset/row");
    digester.addSetNext("*/rowset/row", "addAsset");
    return digester;
  }

  private AssetListResponse getResponseWithParams(
                                                  ApiAuth auth)
    throws IOException {
    Map<String, String> extraParams = new HashMap<String, String>();
    if (flat) extraParams.put("flat", "1");
    return getResponse(auth, extraParams);
  }

  @Override
  public Collection<IAsset> retrieveResponse(
                                             AbstractAPIRequestAdapter adapter)
    throws IOException {
    AssetListResponse response = getResponseWithParams(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IAsset> result = new HashSet<IAsset>();
    result.addAll(response.getAssets());
    return result;
  }

}