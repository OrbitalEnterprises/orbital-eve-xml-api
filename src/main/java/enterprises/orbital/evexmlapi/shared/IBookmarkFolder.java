package enterprises.orbital.evexmlapi.shared;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IBookmarkFolder.class)
public interface IBookmarkFolder {
  public int getFolderID();

  public String getFolderName();

  public long getCreatorID();

  public List<IBookmark> getBookmarks();
}
