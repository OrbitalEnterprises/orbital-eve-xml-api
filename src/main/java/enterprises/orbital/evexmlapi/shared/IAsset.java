package enterprises.orbital.evexmlapi.shared;

import java.util.Collection;

public interface IAsset {
  public Collection<IAsset> getContainedAssets();

  public int getFlag();

  public long getItemID();

  public long getLocationID();

  public int getQuantity();

  public boolean isSingleton();

  public int getTypeID();

  /**
   * Slightly non-intuitive but this value only exists if "isSingleton" is true. We set this field to 0 if isSingleton is false. When isSingleton is true, this
   * field encodes the meaning of the old "negative quantity" interpretation. For example, -1 indicates a blueprint original, and -2 indicates a blueprint copy.
   * 
   * @return singleton meta data if isSingleton is true, otherwise 0.
   */
  public int getRawQuantity();
}
