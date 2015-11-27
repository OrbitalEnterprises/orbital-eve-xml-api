package enterprises.orbital.impl.evexmlapi.crp;

import java.util.ArrayList;
import java.util.Collection;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class CorporationTitlesResponse extends ApiResponse {
  private static final long          serialVersionUID = 4039751364702221904L;
  private final Collection<ApiTitle> titles           = new ArrayList<ApiTitle>();

  public void addTitle(ApiTitle title) {
    titles.add(title);
  }

  public Collection<ApiTitle> getTitles() {
    return titles;
  }
}