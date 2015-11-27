package enterprises.orbital.evexmlapi.shared;

import java.util.List;

public interface IBookmarkFolder {
  public int getFolderID();

  public String getFolderName();

  public long getCreatorID();

  public List<IBookmark> getBookmarks();
}
