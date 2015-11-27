package enterprises.orbital.impl.evexmlapi.crp;

import java.util.ArrayList;
import java.util.Collection;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class ShareholdersResponse extends ApiResponse {
  private static final long                serialVersionUID = 4700451114554348937L;
  private final Collection<ApiShareholder> characters       = new ArrayList<ApiShareholder>();
  private final Collection<ApiShareholder> corporations     = new ArrayList<ApiShareholder>();

  public void addShareholder(ApiShareholder shareholder) {
    if (shareholder.getShareholderCorporationName() == null) {
      corporations.add(shareholder);
    } else {
      characters.add(shareholder);
    }
  }

  public Collection<ApiShareholder> getCharacters() {
    return characters;
  }

  public Collection<ApiShareholder> getCorporations() {
    return corporations;
  }
}