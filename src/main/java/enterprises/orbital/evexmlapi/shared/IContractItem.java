package enterprises.orbital.evexmlapi.shared;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(as = IContractItem.class)
public interface IContractItem {

  public long getRecordID();

  public int getTypeID();

  public long getQuantity();

  public int getRawQuantity();

  public boolean isSingleton();

  public boolean isIncluded();

}
