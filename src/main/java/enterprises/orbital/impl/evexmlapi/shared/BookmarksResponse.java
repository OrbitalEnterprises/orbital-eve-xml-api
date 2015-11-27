package enterprises.orbital.impl.evexmlapi.shared;

import java.util.ArrayList;
import java.util.List;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class BookmarksResponse extends ApiResponse {
  private static final long             serialVersionUID = -1635479183356998240L;

  private final List<ApiBookmarkFolder> folders          = new ArrayList<ApiBookmarkFolder>();

  public List<ApiBookmarkFolder> getBookmarkFolders() {
    return folders;
  }

  public void addBookmarkFolder(ApiBookmarkFolder bm) {
    folders.add(bm);
  }
}