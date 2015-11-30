package enterprises.orbital.impl.evexmlapi.chr;

import enterprises.orbital.impl.evexmlapi.ApiConnector;
import enterprises.orbital.impl.evexmlapi.ApiEndpoint;
import enterprises.orbital.impl.evexmlapi.shared.AbstractContractItemsParser;

public class ContractItemsParser extends AbstractContractItemsParser {
  public ContractItemsParser(ApiConnector connector, Long contractID) {
    super(connector, ApiEndpoint.CHR_CONTRACTS_ITEMS_V1, contractID);
  }
}