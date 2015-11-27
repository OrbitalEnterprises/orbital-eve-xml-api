package enterprises.orbital.impl.evexmlapi.crp;

import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractAssetListParser;

public class AssetListParser extends AbstractAssetListParser {
  public AssetListParser() {
    super(ApiEndpoint.CRP_ASSET_LIST_V2);
  }
}