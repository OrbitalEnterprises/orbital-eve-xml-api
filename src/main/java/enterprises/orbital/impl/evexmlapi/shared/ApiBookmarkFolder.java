package enterprises.orbital.impl.evexmlapi.shared;

import java.util.ArrayList;
import java.util.List;

import enterprises.orbital.evexmlapi.shared.IBookmark;
import enterprises.orbital.evexmlapi.shared.IBookmarkFolder;

public class ApiBookmarkFolder implements IBookmarkFolder {
  private int                     folderID;
  private String                  folderName;
  private long                    creatorID;
  private final List<ApiBookmark> bookmarks = new ArrayList<ApiBookmark>();

  @Override
  public int getFolderID() {
    return folderID;
  }

  @Override
  public String getFolderName() {
    return folderName;
  }

  public void setFolderName(String folderName) {
    this.folderName = folderName;
  }

  @Override
  public long getCreatorID() {
    return creatorID;
  }

  public void setCreatorID(long creatorID) {
    this.creatorID = creatorID;
  }

  public void setFolderID(int folderID) {
    this.folderID = folderID;
  }

  @Override
  public List<IBookmark> getBookmarks() {
    List<IBookmark> result = new ArrayList<IBookmark>();
    result.addAll(bookmarks);
    return result;
  }

  public void addBookmark(ApiBookmark bm) {
    bookmarks.add(bm);
  }

}