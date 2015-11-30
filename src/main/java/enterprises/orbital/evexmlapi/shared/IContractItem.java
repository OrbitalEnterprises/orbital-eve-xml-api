package enterprises.orbital.evexmlapi.shared;

public interface IContractItem {

  public long getRecordID();

  public int getTypeID();

  public long getQuantity();

  public int getRawQuantity();

  public boolean isSingleton();

  public boolean isIncluded();

}
