package enterprises.orbital.impl.evexmlapi.shared;

import java.util.ArrayList;
import java.util.Collection;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class ContractBidsResponse extends ApiResponse {
  private final Collection<ApiContractBid> bids = new ArrayList<ApiContractBid>();

  public void addContractBid(ApiContractBid entry) {
    bids.add(entry);
  }

  public Collection<ApiContractBid> getContractBids() {
    return bids;
  }
}