package enterprises.orbital.evexmlapi.shared;

import java.util.Date;

public interface IBookmark {

  public int getBookmarkID();

  public long getCreatorID();

  public Date getCreated();

  public long getItemID();

  public int getTypeID();

  public long getLocationID();

  public double getX();

  public double getY();

  public double getZ();

  public String getMemo();

  public String getNote();

}
