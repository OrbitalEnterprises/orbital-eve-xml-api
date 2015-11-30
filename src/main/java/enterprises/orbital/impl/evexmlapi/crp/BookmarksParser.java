package enterprises.orbital.impl.evexmlapi.crp;

import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractBookmarksParser;

public class BookmarksParser extends AbstractBookmarksParser {
  public BookmarksParser(ApiConnector connector) {
    super(connector, ApiEndpoint.CRP_BOOKMARKS_V2);
  }
}