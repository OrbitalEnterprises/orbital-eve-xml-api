package enterprises.orbital.impl.evexmlapi.crp;

import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractAssetListParser;

public class AssetListParser extends AbstractAssetListParser {
  public AssetListParser(ApiConnector connector) {
    super(connector, ApiEndpoint.CRP_ASSET_LIST_V2);
  }
}