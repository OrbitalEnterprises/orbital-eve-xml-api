package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractBookmarksParser;

public class BookmarksParser extends AbstractBookmarksParser {
  public BookmarksParser() {
    super(ApiEndpoint.CHR_BOOKMARKS_V2);
  }

}