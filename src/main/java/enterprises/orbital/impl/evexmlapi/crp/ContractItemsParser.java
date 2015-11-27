package enterprises.orbital.impl.evexmlapi.crp;

import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractContractItemsParser;

public class ContractItemsParser extends AbstractContractItemsParser {
  public ContractItemsParser(Long contractID) {
    super(ApiEndpoint.CRP_CONTRACTS_ITEMS_V1, contractID);
  }
}