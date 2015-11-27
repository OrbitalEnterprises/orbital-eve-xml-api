package enterprises.orbital.impl.evexmlapi.shared;

import java.util.Collection;
import java.util.HashSet;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class AssetListResponse extends ApiResponse {
  private static final long          serialVersionUID = 8933918595345946744L;
  private final Collection<ApiAsset> assets           = new HashSet<ApiAsset>();

  public void addAsset(ApiAsset asset) {
    assets.add(asset);
  }

  public Collection<ApiAsset> getAssets() {
    return assets;
  }
}
