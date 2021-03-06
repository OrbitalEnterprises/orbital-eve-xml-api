package enterprises.orbital.impl.evexmlapi.shared;

import java.util.ArrayList;
import java.util.Collection;

import enterprises.orbital.impl.evexmlapi.ApiResponse;

public class ContractsResponse extends ApiResponse {
  private final Collection<ApiContract> contracts = new ArrayList<ApiContract>();

  public void addContract(ApiContract entry) {
    contracts.add(entry);
  }

  public Collection<ApiContract> getContracts() {
    return contracts;
  }
}