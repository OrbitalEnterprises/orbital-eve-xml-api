package enterprises.orbital.impl.evexmlapi.crp;

import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractBookmarksParser;

public class BookmarksParser extends AbstractBookmarksParser {
  public BookmarksParser() {
    super(ApiEndpoint.CRP_BOOKMARKS_V2);
  }
}