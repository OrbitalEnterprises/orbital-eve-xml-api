package enterprises.orbital.impl.evexmlapi.crp;

import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractContractBidsParser;

public class ContractBidsParser extends AbstractContractBidsParser {
  public ContractBidsParser() {
    super(ApiEndpoint.CRP_CONTRACTS_BIDS_V1);
  }
}