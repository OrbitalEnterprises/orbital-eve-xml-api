package enterprises.orbital.impl.evexmlapi.shared;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import org.apache.commons.digester.Digester;

import enterprises.orbital.evexmlapi.shared.IBookmarkFolder;
import enterprises.orbital.impl.evexmlapi.AbstractAPIRequestAdapter;
import enterprises.orbital.impl.evexmlapi.AbstractApiParser;
import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;

public abstract class AbstractBookmarksParser extends AbstractApiParser<BookmarksResponse, Collection<IBookmarkFolder>> {
  protected AbstractBookmarksParser(ApiConnector connector, ApiEndpoint endpoint) {
    super(connector, BookmarksResponse.class, endpoint);
  }

  @Override
  protected Digester getDigester() {
    Digester digester = super.getDigester();
    digester.addObjectCreate("eveapi/result/rowset/row", ApiBookmarkFolder.class);
    digester.addSetProperties("eveapi/result/rowset/row");
    digester.addObjectCreate("eveapi/result/rowset/row/rowset/row", ApiBookmark.class);
    digester.addSetProperties("eveapi/result/rowset/row/rowset/row");
    digester.addSetNext("eveapi/result/rowset/row/rowset/row", "addBookmark");
    digester.addSetNext("eveapi/result/rowset/row", "addBookmarkFolder");
    return digester;
  }

  @Override
  public Collection<IBookmarkFolder> retrieveResponse(AbstractAPIRequestAdapter adapter) throws IOException {
    BookmarksResponse response = getResponse(adapter.getAuth());
    adapter.setFromLastResponse(response);
    if (adapter.isError()) return null;
    Collection<IBookmarkFolder> result = new ArrayList<IBookmarkFolder>();
    result.addAll(response.getBookmarkFolders());
    return result;
  }

}