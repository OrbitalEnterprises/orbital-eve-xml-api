package enterprises.orbital.evexmlapi.shared;

import java.util.Collection;

public interface IKillItem {
  public Collection<IKillItem> getContainedItems();

  public int getFlag();

  public int getQtyDestroyed();

  public int getQtyDropped();

  public int getTypeID();

  public boolean isSingleton();
}
