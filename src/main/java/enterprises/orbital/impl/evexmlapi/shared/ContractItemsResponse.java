package enterprises.orbital.impl.evexmlapi.shared;

import java.util.ArrayList;
import java.util.Collection;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class ContractItemsResponse extends ApiResponse {
  private static final long                 serialVersionUID = 183510657181116875L;
  private final Collection<ApiContractItem> items            = new ArrayList<ApiContractItem>();

  public void addContractItem(ApiContractItem entry) {
    items.add(entry);
  }

  public Collection<ApiContractItem> getContractItems() {
    return items;
  }
}