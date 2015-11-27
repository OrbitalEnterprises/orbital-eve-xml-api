package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractContractBidsParser;

public class ContractBidsParser extends AbstractContractBidsParser {
  public ContractBidsParser() {
    super(ApiEndpoint.CHR_CONTRACTS_BIDS_V1);
  }

}