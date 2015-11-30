package enterprises.orbital.evexmlapi.api;

public interface ICall {
  public long getAccessMask();

  public String getType();

  public String getName();

  public int getGroupID();

  public String getDescription();
}
